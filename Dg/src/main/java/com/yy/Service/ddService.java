package com.yy.Service;

import com.yy.DAO.LogisticsMapper;
import com.yy.DAO.Order_detailMapper;
import com.yy.DAO.OrdergMapper;
import com.yy.POJO.*;
import com.yy.Util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 袁毅
 * @date 2018/12/19 0019-下午 10:20
 */
@Service
public class ddService {

    @Autowired
    Order_detailMapper order_detailMapper;

    @Autowired
    OrdergMapper ordergMapper;

    @Autowired
    LogisticsMapper logisticsMapper;
public List<Logistics> insertDD(Users users){


    //构造收货地址条件
    LogisticsExample logisticsExample = new LogisticsExample();
    LogisticsExample.Criteria criteria = logisticsExample.createCriteria();
    criteria.andUidEqualTo(users.getUid());
    //查询
    List<Logistics> logistics = logisticsMapper.selectByExample(logisticsExample);

    Date date = new Date();


    Orderg orderg = new Orderg(users.getUid(),date,logistics.get(0).getLaddress(),logistics.get(0).getLname(),Shopcar.getTotalPrice(),TimeUtil.getTime(),"未发货");

    ordergMapper.insertSelective(orderg);
    for (BuyerItem b :Shopcar.getShopCar()
            ) {



        Order_detail orderDetail = new Order_detail(orderg.getOid(),b.getGoods().getGid(),b.getGoods().getQty()*b.getGoods().getGprice()*b.getGoods().getGdiscount(),b.getGoods().getQty());
        order_detailMapper.insertSelective(orderDetail);

    }


    return logistics;


}





}
