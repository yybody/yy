package com.example.demo.Dao;

import com.example.demo.PoJo.employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 袁毅
 * @date 2019/3/21 0021-下午 5:45
 */
public interface empMapper {

    employee getById(@Param("id") Integer id);

    @Select("select * from employee where lastName = #{lastName}")
    employee getById2(String lastName);

    void updateById(employee e);

}
