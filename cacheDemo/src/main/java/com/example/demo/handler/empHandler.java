package com.example.demo.handler;

import com.example.demo.PoJo.employee;
import com.example.demo.service.empService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 袁毅
 * @date 2019/3/21 0021-下午 6:28
 */
@RestController
public class empHandler {

    @Autowired(required = false)
    empService service;


    @GetMapping("/emp/{id}")
    public employee getEmployeeHandler(@PathVariable("id") Integer id){

        employee employee = service.getEmployee(id);

        return employee;


    }

}
