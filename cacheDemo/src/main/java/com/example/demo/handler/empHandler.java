package com.example.demo.handler;

import com.example.demo.PoJo.employee;
import com.example.demo.service.empService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 袁毅
 * @date 2019/3/21 0021-下午 6:28
 */
@RestController
public class empHandler {

    @Autowired(required = false)
    empService service;


    @GetMapping("/emp")
    public employee getEmployeeHandler(@RequestParam("id") Integer e){

        employee employee = service.getEmployee(e);

        return employee;


    }

    @GetMapping("/up")
    public void updateEmployee(employee e){


        service.updateEmployee(e);

    }
    @GetMapping("/emp/{id}")
    public employee getEmployeeHandler2(@PathVariable Integer id){

        employee employee2 = service.getEmployee2(id);
        return  employee2;

    }

    @GetMapping("/emp/lastName/{lastName}")
    public employee getEmployeeHandler2(@PathVariable String lastName){

        employee employee2 = service.getEmployee3(lastName);
        return  employee2;

    }
}
