package com.yy.Service;

import com.yy.DAO.AccountMapper;
import com.yy.DAO.GoodsMapper;
import com.yy.DAO.UsersMapper;
import com.yy.POJO.*;
import com.yy.ex.payEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 袁毅
 * @date 2018/12/25 0025-下午 2:04
 */
@Service
public class payService {
    @Autowired
    GoodsMapper mapper;
    @Autowired
    UsersMapper usersMapper;

    @Autowired
    AccountMapper accountMapper;
    //开启事物，处理用户的购物
    @Transactional
    public void shopGood(Integer uid){
        List<BuyerItem> shopCar1 = Shopcar.getShopCar();

        for (BuyerItem b:shopCar1
             ) {
            b.getAmount();
            Goods goods = mapper.selectByPrimaryKey(b.getGoods().getGid());
            if (goods.getQty()<b.getAmount()){

                throw  new payEx("库存不足");
            }
            goods.setQty(goods.getQty()-b.getAmount());
            GoodsExample goodsExample = new GoodsExample();
            GoodsExample.Criteria criteria = goodsExample.createCriteria();
            criteria.andGidEqualTo(goods.getGid());
            mapper.updateByExampleSelective(goods, goodsExample);





            //账户金额

            AccountExample accountExample = new AccountExample();
            AccountExample.Criteria accoutcri = accountExample.createCriteria();

            accoutcri.andUidEqualTo(uid);
            //商品价钱
            float sum = b.getGoods().getGprice()*b.getGoods().getGdiscount()*b.getAmount();
            List<Account> accounts = accountMapper.selectByExample(accountExample);
            float money = accounts.get(0).getMoney()-sum;
            if (money<0) {throw  new payEx("余额不足");}
            accountMapper.updateByExample(new Account(money),accountExample);
        }








    }




}
