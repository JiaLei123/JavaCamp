package jialei.com.spitter.demoredis.config;

import jialei.com.spitter.model.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisConnectionFactory redisCf(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("localhost");
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<String, Order> redisTemplate(RedisConnectionFactory cf){
        RedisTemplate<String, Order>  redis = new RedisTemplate<String, Order>();
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new Jackson2JsonRedisSerializer<Order>(Order.class));
        redis.setConnectionFactory(cf);
        return redis;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory cf){
        StringRedisTemplate  redis = new StringRedisTemplate();
        redis.setConnectionFactory(cf);
        return redis;
    }
}
