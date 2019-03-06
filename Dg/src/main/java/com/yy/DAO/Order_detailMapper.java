package com.yy.DAO;

import com.yy.POJO.Order_detail;
import com.yy.POJO.Order_detailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Order_detailMapper {
    long countByExample(Order_detailExample example);

    int deleteByExample(Order_detailExample example);

    int deleteByPrimaryKey(Integer odid);

    int insert(Order_detail record);

    int insertSelective(Order_detail record);

    List<Order_detail> selectByExample(Order_detailExample example);

    Order_detail selectByPrimaryKey(Integer odid);

    int updateByExampleSelective(@Param("record") Order_detail record, @Param("example") Order_detailExample example);

    int updateByExample(@Param("record") Order_detail record, @Param("example") Order_detailExample example);

    int updateByPrimaryKeySelective(Order_detail record);

    int updateByPrimaryKey(Order_detail record);
}