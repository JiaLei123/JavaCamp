package com.jialei.MagicBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JiaLei on 2017/3/26.
 */
@Configuration
public class MaginBeanConfig {

    @Bean
    @Conditional(MagicBeanConditon.class)
    public MagicBean maginBean(){
        return new MagicBean();
    }
}
