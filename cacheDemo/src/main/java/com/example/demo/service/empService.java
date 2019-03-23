package com.example.demo.service;

import com.example.demo.Dao.empMapper;
import com.example.demo.PoJo.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author 袁毅
 * @date 2019/3/21 0021-下午 6:25
 */
@Service
@CacheConfig(cacheNames = "emp2")//抽取公共配置
public class empService {

    @Autowired(required = false)
    empMapper mapper;
    /*
    将返回值放入缓存
     @Cacheable
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
    @Cacheable()
    public employee getEmployee(Integer id){

        employee byId = mapper.getById(id);

        return  byId;
    }/*
       将返回值放入缓存
       @CachePut用于更新缓存，每次执行后缓存更新
       cachenames指定缓存名字
    * key指定缓存数据的key
    * keygenerator指定key的生成器，key和keygenerator2选一
    * condition判断条件，满足时提交
    * unless判断条件，满足时不提交，condition和unless2选一
    * cachemanger，缓存管理器
    * sync：异步
    * !注意在更新缓存时要保证缓存的类型相同




    */
    @CachePut(key = "#e.id")
    public void updateEmployee(employee e){

        mapper.updateById(e);


    }
    /*
    @CacheEvict用于清空缓存
    allentries = ture 指定清除所有缓存
    beforeincocation =false 指定缓存清除是在方法执行后执行
    */

     /*
     * @caching相当于cacheable，cacheput和cacheevict组合
     * */



    @Caching(
            cacheable = {@Cacheable(key = "#id")},
            put = {@CachePut(key = "#result.email"),
            @CachePut(key = "#result.lastName")
            }
    )
    public employee getEmployee2(Integer id){

       employee e = mapper.getById(id);



       return e;
    }

    @Cacheable()
    public employee getEmployee3(String name){

        employee byId = mapper.getById2(name);

        return  byId;
    }


}
