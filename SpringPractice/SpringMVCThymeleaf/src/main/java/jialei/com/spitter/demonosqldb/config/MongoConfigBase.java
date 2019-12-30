package jialei.com.spitter.demonosqldb.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

//@Configuration
//@EnableMongoRepositories(basePackages = "jialei.com.spitter.demonosqldb.repository")
public class MongoConfigBase {
    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        return new MongoClient("localhost");
    }

    @Bean
    public  MongoOperations mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "OrdersDB");
    }
}
