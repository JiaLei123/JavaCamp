package com.jialei.myspringboot.democache.config;

import com.jialei.myspringboot.demomybatis.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<Object, Role> myRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, Role> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<Role>(Role.class));
        return template;
    }

    @Primary
    @Bean
    public RedisCacheManager roleCacheManager(RedisTemplate<Object, Role> myRedisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(myRedisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }
}
