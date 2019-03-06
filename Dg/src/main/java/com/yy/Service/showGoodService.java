package com.yy.Service;

import com.yy.DAO.GoodsMapper;
import com.yy.POJO.Goods;
import com.yy.POJO.GoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 袁毅
 * @date 2018/12/16 0016-下午 4:51
 */
@Service
public class showGoodService {

    @Autowired
    GoodsMapper goodsMapper;
    //构造条件查询
    public List<Goods> getGood(Integer m2id){
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andM2idEqualTo(m2id);
        List<Goods> list = new ArrayList<>();
        list = goodsMapper.selectByExample(goodsExample);

        return list;
    }

}
