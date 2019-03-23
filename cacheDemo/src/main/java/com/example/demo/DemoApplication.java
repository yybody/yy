package com.example.demo;

import com.example.demo.PoJo.employee;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/*
* 1.对springboot进行简单的配置基本的配置，即springboot的初始化配置
* 2.对mybatis进行初始化配置
* 3.若要实现其他功能则进行相应配置，如@EnableCaching开启注解
* */
/**
 *引入redis配置：
 * 				1.首先引入场景，创建相应的managenr,@Primary设置为默认的缓存管理器
 * 			    2.在配置文件完成相应配置
 * 			    3.注入template
 * 			    4.可以配置扩展template
 * 			    5.redis是基于缓存的数据库所以要开启缓存
 */

@EnableCaching
@MapperScan("com.example.demo.Dao")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



}
