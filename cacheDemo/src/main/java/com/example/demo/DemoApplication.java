package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*
* 1.对springboot进行简单的配置基本的配置，即springboot的初始化配置
* 2.对mybatis进行初始化配置
* 3.若要实现其他功能则进行相应配置，如@EnableCaching开启注解
* */
@EnableCaching
@MapperScan("com.example.demo.Dao")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
