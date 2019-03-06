package com.yy.POJO;

/**
 * @author 袁毅
 * @date 2018/11/28 0028-下午 2:13
 * BuyerItem购物项
 */
public class BuyerItem {

    Goods goods;//商品及详细信息

    private Integer amount;//商品数量

    public BuyerItem() {
    }

    public BuyerItem(Goods goods, Integer amount) {
        this.goods = goods;
        this.amount = amount;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
