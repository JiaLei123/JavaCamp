package jialei.com.spitter.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "jialei.com.spitter.repository")
public class MongoConfigAdv extends AbstractMongoClientConfiguration {
    @Override
    protected String getDatabaseName() {
        return "OrdersDB";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017/?replicaSet=rs0&w=majority");
    }
}
