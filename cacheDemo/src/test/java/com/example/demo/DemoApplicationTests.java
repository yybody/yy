package com.example.demo;

import com.example.demo.Dao.empMapper;
import com.example.demo.PoJo.employee;
import com.example.demo.service.empService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired(required = false)
	empService mapper;

	@Test
	public void contextLoads() {


         mapper.updateEmployee(new employee(1,"y5","861040188@qq.com",1,1));

    }
    //导入redis模板
    @Autowired
    RedisTemplate<Object,Object> getRedisTemplate;

    @Test
	public void test01(){

    	employee employee = mapper.getEmployee(1);
//        getRedisTemplate.opsForValue().set("redis",employee);
		getRedisTemplate.opsForList().leftPush("mylist2",employee);
        getRedisTemplate.opsForList().leftPush("mylist2",new employee());

	}

}
