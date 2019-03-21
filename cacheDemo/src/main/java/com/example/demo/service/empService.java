package com.example.demo.service;

import com.example.demo.Dao.empMapper;
import com.example.demo.PoJo.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author 袁毅
 * @date 2019/3/21 0021-下午 6:25
 */
@Service
public class empService {

    @Autowired(required = false)
    empMapper mapper;
    /*
    * cachenames指定缓存名字
    * key指定缓存数据的key
    * keygenerator指定key的生成器，key和keygenerator2选一
    * condition判断条件，满足时提交
    * unless判断条件，满足时不提交，condition和unless2选一
    * cachemanger，缓存管理器
    * sync：异步
    *
    *
    *
    *
    * */
    @Cacheable(cacheNames = "emp",key = "s",condition = "#id>2")
    public employee getEmployee(Integer id){

        employee byId = mapper.getById(id);

        return  byId;
    }


}
