package com.jialei;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by JiaLei on 2017/3/25.
 */
@Configuration
@ComponentScan
public class CompactDiscConfig {
    @Bean
    @Profile("dev")
    public CompactDisc getBlankDisc(){
        return new BlankDisc();
    }

    @Bean
    @Profile("Test")
    public CompactDisc getStgDisc(){
        return new StgDisc();
    }
}
