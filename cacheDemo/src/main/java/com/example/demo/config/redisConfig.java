package com.example.demo.config;

import com.example.demo.PoJo.employee;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author 袁毅
 * @date 2019/3/23 0023-下午 10:55
 */
@Configuration
public class redisConfig {
    //设置redis模板，对redis的操作都由它实现，但要使Redismanager使用它就需要更改redismanager设置
    @Bean
    public RedisTemplate<Object, Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object,Object>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        template.setDefaultSerializer(objectJackson2JsonRedisSerializer);
        return template;
    }

    //自定义redismanager


}
