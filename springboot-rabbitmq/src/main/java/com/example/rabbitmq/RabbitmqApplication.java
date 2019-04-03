package com.example.rabbitmq;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqApplication {
	//引入相应场景启动器
	//进行相应配置
	//开启使用注解
	/*自动配置
	* RabbitAutoConfiguration
	* 自动配置连接工厂connectionFactory
	* 消息队列操作对象rabbitTemplate
	* 消息队列配置类RabbitProperties
	* AmqpAdmin：Rabbitmq的管理，创建等
	* */
//ctrl+h查看接口和类的实现
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}



	@Bean
	public MessageConverter insertMessageConverter(){

		return new Jackson2JsonMessageConverter();
	}
}