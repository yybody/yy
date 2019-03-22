package com.example.demo;

import com.example.demo.Dao.empMapper;
import com.example.demo.PoJo.employee;
import com.example.demo.service.empService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired(required = false)
	empService mapper;

	@Test
	public void contextLoads() {

         employee byId = mapper.getEmployee(1);
		 System.out.println(byId.toString());
         mapper.updateEmployee(new employee(1,"y4","861040188@qq.com",1,1));

    }

}
