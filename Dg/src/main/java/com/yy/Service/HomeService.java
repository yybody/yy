package com.yy.Service;

import com.yy.DAO.GoodsMapper;
import com.yy.DAO.Menu1Mapper;
import com.yy.DAO.Menu2Mapper;
import com.yy.POJO.Goods;
import com.yy.POJO.GoodsExample;
import com.yy.POJO.Menu1;
import com.yy.POJO.Menu2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 袁毅
 * @date 2018/12/15 0015-下午 6:17
 */
@Service
public class HomeService {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    Menu1Mapper menu1Mapper;
    @Autowired
    Menu2Mapper menu2Mapper;

    //显示推荐的主要商品
    public List<Goods> getHome(){
       List<Menu2> list =  menu2Mapper.selectByPrimaryKey2(1);
       List<Goods> goodsList = new ArrayList<>();
       for (Menu2 m :list){
           //设置条件类
           GoodsExample g = new GoodsExample();
           GoodsExample.Criteria criteria = g.createCriteria();
           criteria.andM2idEqualTo(m.getM2id());
           //按条件查询的商品
           goodsList.addAll(goodsMapper.selectByExample(g));




       }

        return goodsList;
    }

    //查询1及菜单显示出来
    public List<Menu1> getMenu1(){

        List<Menu1> list = new ArrayList<>();
        list = menu1Mapper.selectAll();


        return list;
    }
    public List<Menu2> getMenu2(){
        List<Menu1> list = getMenu1();
        List<Menu2> menu2List = new ArrayList<>();
        for (Menu1 menu1:list){

            List<Menu2> menu2List1=  menu2Mapper.selectByPrimaryKey2(menu1.getM1id());
            menu2List.addAll(menu2List1);
        }

        return menu2List;

    }



}
