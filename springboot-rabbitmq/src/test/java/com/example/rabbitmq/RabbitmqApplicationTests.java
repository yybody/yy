package com.example.rabbitmq;

import com.example.rabbitmq.Bean.book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {


	@Autowired
	RabbitTemplate rabbitTemplate;//操作rabbitmq的对象
	@Test
	public void contextLoads() {
//		rabbitTemplate.send(exchange,routingkey,message);参数message是需要自己构造自定义消息头和消息体内容
		Map<String,String> map = new HashMap<>();
		map.put("data","这是一个消息队列");
		rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new book("天下第一","袁毅"));//convertAndSend(exchange,routingkey,object)object默认当层消息体只要传入即可


	}
	@Test
	public void receiveRabbit(){

        /*
        * receiveAndConvert接收消息体
        * receive接收消息头和消息体
        * */
		book o = (book) rabbitTemplate.receiveAndConvert("atguigu.news");
		System.out.println(o.getAuthor());

	}

}
