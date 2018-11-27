package com.jialei.scopebean;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by JiaLei on 2018/11/27.
 */

@Configuration
public class ExplicitConfig {
    @Bean
    @Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
    public NotePad notePad() {
        return new NotePad();
    }

    @Bean
    public UniqueThing uniqueThing() {
        return new UniqueThing();
    }
}

