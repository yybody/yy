package com.yy.DAO;

import com.yy.POJO.Menu2;
import com.yy.POJO.Menu2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Menu2Mapper {
    long countByExample(Menu2Example example);

    int deleteByExample(Menu2Example example);

    int deleteByPrimaryKey(Integer m2id);

    int insert(Menu2 record);

    int insertSelective(Menu2 record);

    List<Menu2> selectByExample(Menu2Example example);
    List<Menu2> selectAll();

    Menu2 selectByPrimaryKey(Integer m2id);
    List<Menu2> selectByPrimaryKey2(Integer m1id);

    int updateByExampleSelective(@Param("record") Menu2 record, @Param("example") Menu2Example example);

    int updateByExample(@Param("record") Menu2 record, @Param("example") Menu2Example example);

    int updateByPrimaryKeySelective(Menu2 record);

    int updateByPrimaryKey(Menu2 record);
}