package com.yy.DAO;

import com.yy.POJO.Logistics;
import com.yy.POJO.LogisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogisticsMapper {
    long countByExample(LogisticsExample example);

    int deleteByExample(LogisticsExample example);

    int deleteByPrimaryKey(Integer lid);

    int insert(Logistics record);

    int insertSelective(Logistics record);

    List<Logistics> selectByExampleWithBLOBs(LogisticsExample example);

    List<Logistics> selectByExample(LogisticsExample example);

    Logistics selectByPrimaryKey(Integer lid);

    int updateByExampleSelective(@Param("record") Logistics record, @Param("example") LogisticsExample example);

    int updateByExampleWithBLOBs(@Param("record") Logistics record, @Param("example") LogisticsExample example);

    int updateByExample(@Param("record") Logistics record, @Param("example") LogisticsExample example);

    int updateByPrimaryKeySelective(Logistics record);

    int updateByPrimaryKeyWithBLOBs(Logistics record);

    int updateByPrimaryKey(Logistics record);
}