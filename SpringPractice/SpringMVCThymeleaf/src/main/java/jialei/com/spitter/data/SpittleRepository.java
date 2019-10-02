package jialei.com.spitter.data;

import jialei.com.spitter.model.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(int count);

    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long id);

    List<Spittle> findSpittles(String message);

    void save(Spittle spittle);

}
