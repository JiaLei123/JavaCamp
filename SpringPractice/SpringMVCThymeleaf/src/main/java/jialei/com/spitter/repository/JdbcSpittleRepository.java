package jialei.com.spitter.repository;

import jialei.com.spitter.model.DuplicateSpittleException;
import jialei.com.spitter.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return jdbc.query(
                "select id, message, created_at, latitude, longitude" +
                        " from Spittle" +
                        " where id < ?" +
                        " order by created_at desc limit 20",
                new SpittleRowMapper(), max);
    }

    @Override
    public List<Spittle> findSpittles(int count) {
        return jdbc.query(
                "select id, message, created_at, latitude, longitude" +
                        " from Spittle" +
                        " order by created_at desc limit 20",
                new SpittleRowMapper());
    }

    public void save(Spittle spittle) {
        List<Spittle> existSpittle = findSpittles(spittle.getMessage());
        if(existSpittle.size() > 0){
            throw new DuplicateSpittleException();
        }

        jdbc.update(
                "insert into Spittle (message, created_at, latitude, longitude)" +
                        " values (?, ?, ?, ?)",
                spittle.getMessage(),
                spittle.getTime(),
                spittle.getLatitude(),
                spittle.getLongitude());
    }

    public List<Spittle> findSpittles(String message){
        return jdbc.query(
                "select id, message, created_at, latitude, longitude" +
                        " from Spittle" +
                        " where message = ?",
                new SpittleRowMapper(), message);
    }

    public Spittle findOne(long id) {
         List<Spittle> spittles = jdbc.query(
                "select id, message, created_at, latitude, longitude" +
                        " from Spittle" +
                        " where id = ?",
                new SpittleRowMapper(), id);
        return spittles.size()>0? spittles.get(0):null;
    }


    private static class SpittleRowMapper implements RowMapper<Spittle> {

        @Override
        public Spittle mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Spittle(
                    resultSet.getLong("id"),
                    resultSet.getString("message"),
                    resultSet.getDate("created_at"),
                    resultSet.getDouble("longitude"),
                    resultSet.getDouble("latitude")
            );
        }
    }
}
