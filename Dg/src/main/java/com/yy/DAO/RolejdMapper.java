package com.yy.DAO;

import com.yy.POJO.Rolejd;
import com.yy.POJO.RolejdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolejdMapper {
    long countByExample(RolejdExample example);

    int deleteByExample(RolejdExample example);

    int deleteByPrimaryKey(Integer rjid);

    int insert(Rolejd record);

    int insertSelective(Rolejd record);

    List<Rolejd> selectByExample(RolejdExample example);

    Rolejd selectByPrimaryKey(Integer rjid);

    int updateByExampleSelective(@Param("record") Rolejd record, @Param("example") RolejdExample example);

    int updateByExample(@Param("record") Rolejd record, @Param("example") RolejdExample example);

    int updateByPrimaryKeySelective(Rolejd record);

    int updateByPrimaryKey(Rolejd record);
}