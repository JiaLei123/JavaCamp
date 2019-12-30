package jialei.com.spitter.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
//@EnableMongoRepositories(basePackages = "jialei.com.spitter.demonosqldb.repository")
public class MongoConfigAdv extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "OrdersDB";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost");
    }
}
