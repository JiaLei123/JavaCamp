package jialei.com.spitter.demonosqldb.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "jialei.com.spitter.demonosqldb.repository")
public class MongoConfigBase {
    @Bean
    public MongoFactoryBean mongo(){
        MongoFactoryBean mongo = new MongoFactoryBean();
        mongo.setHost("localhost");
        return mongo;
    }

    @Bean
    public MongoOperations mongoTempalte(Mongo mongo){
        return new MongoTemplate(mongo, "OrdersDB");
    }
}
