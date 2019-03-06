package com.yy.DAO;

import com.yy.POJO.Appraise;
import com.yy.POJO.AppraiseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppraiseMapper {
    long countByExample(AppraiseExample example);

    int deleteByExample(AppraiseExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Appraise record);

    int insertSelective(Appraise record);

    List<Appraise> selectByExampleWithBLOBs(AppraiseExample example);

    List<Appraise> selectByExample(AppraiseExample example);

    Appraise selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Appraise record, @Param("example") AppraiseExample example);

    int updateByExampleWithBLOBs(@Param("record") Appraise record, @Param("example") AppraiseExample example);

    int updateByExample(@Param("record") Appraise record, @Param("example") AppraiseExample example);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKeyWithBLOBs(Appraise record);

    int updateByPrimaryKey(Appraise record);
}