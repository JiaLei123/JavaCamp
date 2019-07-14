package com.jialei.propertyBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/properties/app.properties")
public class EnvironmentConfig {
    @Autowired
    Environment environment;

    @Bean
    public BlankDisc disc(){
        return new BlankDisc(environment.getProperty("disc.title"), environment.getProperty("disc.artist"));
    }
}
