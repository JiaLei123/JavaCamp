package com.jialei.myspringboot.democache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * @author jialei
 * @version : CacheConfig.java, v 0.1 2019年12月23日 3:12 下午 jialei Exp $
 */
@Configuration
public class CacheConfig {
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName() + "["+ Arrays.asList(params) +"]";
            }
        };
    }
}