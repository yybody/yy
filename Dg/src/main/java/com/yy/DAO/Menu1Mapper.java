package com.yy.DAO;

import com.yy.POJO.Menu1;
import com.yy.POJO.Menu1Example;
import java.util.List;

import com.yy.POJO.Menu2;
import org.apache.ibatis.annotations.Param;

public interface Menu1Mapper {
    long countByExample(Menu1Example example);

    int deleteByExample(Menu1Example example);

    int deleteByPrimaryKey(Integer m1id);

    int insert(Menu1 record);

    int insertSelective(Menu1 record);

    List<Menu1> selectByExample(Menu1Example example);

    List<Menu1> selectAll();

    Menu1 selectByPrimaryKey(Integer m1id);

    int updateByExampleSelective(@Param("record") Menu1 record, @Param("example") Menu1Example example);

    int updateByExample(@Param("record") Menu1 record, @Param("example") Menu1Example example);

    int updateByPrimaryKeySelective(Menu1 record);

    int updateByPrimaryKey(Menu1 record);
}