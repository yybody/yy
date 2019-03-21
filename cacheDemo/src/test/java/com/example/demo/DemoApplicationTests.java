package com.example.demo;

import com.example.demo.Dao.empMapper;
import com.example.demo.PoJo.employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired(required = false)
	empMapper mapper;

	@Test
	public void contextLoads() {

        employee byId = mapper.getById(1);
        System.out.println(byId.toString());

    }

}
