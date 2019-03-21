package com.example.demo.Dao;

import com.example.demo.PoJo.employee;
import org.apache.ibatis.annotations.Param;

/**
 * @author 袁毅
 * @date 2019/3/21 0021-下午 5:45
 */
public interface empMapper {

    employee getById(@Param("id") Integer id);

    int updateById();

}
