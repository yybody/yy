package com.yy.Service;

import com.yy.DAO.GoodsMapper;
import com.yy.POJO.Goods;
import com.yy.POJO.GoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 袁毅
 * @date 2018/11/28 0028-下午 4:06
 *库存检查
 */
@Service
public class GoodService {

    @Autowired
    GoodsMapper goodsMapper;

    public boolean checkGood(Integer goodNumber,Integer gid){

        Goods goods =goodsMapper.selectByPrimaryKey(gid);
        if (goods == null) return false;
        return goods.getQty()>=goodNumber ? true:false;
    }
    public Goods getGood(Integer gid){

        Goods goods =goodsMapper.selectByPrimaryKey(gid);

        return goods;
    }

}
