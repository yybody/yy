package com.yy.DAO;

import com.yy.POJO.Orderg;
import com.yy.POJO.OrdergExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdergMapper {
    long countByExample(OrdergExample example);

    int deleteByExample(OrdergExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(Orderg record);

    int insertSelective(Orderg record);

    List<Orderg> selectByExample(OrdergExample example);

    Orderg selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") Orderg record, @Param("example") OrdergExample example);

    int updateByExample(@Param("record") Orderg record, @Param("example") OrdergExample example);

    int updateByPrimaryKeySelective(Orderg record);

    int updateByPrimaryKey(Orderg record);
}