package jialei.com.spitter.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


import javax.sql.DataSource;


@Configuration
public class DataConfig {
    @Profile("test")
    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql")
                .build();
    }

    @Profile("dev")
    @Bean
    public DataSource druid(){
        DruidDataSource druid = new DruidDataSource();
        druid.setUsername("root");
        druid.setPassword("123123");
        druid.setDriverClassName("com.mysql.jdbc.Driver");
        druid.setUrl("jdbc:mysql://localhost:3306/Spitter");
        return druid;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
