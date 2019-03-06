package com.yy.POJO;



import java.util.ArrayList;
import java.util.List;

public class Shopcar {
    private Integer cid;

    private Integer uid;

    private Integer gid;

    private Integer quantity;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    private static List<BuyerItem> shopCar = new ArrayList<>();//购物车

    public static void addCar(BuyerItem buyerItem){//将购物项添加到购物车
        System.out.println(shopCar.size());

       if (shopCar.size()!=0){

           for (BuyerItem buyerItem1:shopCar){

            //   System.out.println(buyerItem1.goods.getGid()+"sd"+buyerItem.goods.getGid());
               if (buyerItem1.goods.getGid().intValue()==buyerItem.goods.getGid().intValue()){
                   System.out.println("一样");
                   buyerItem1.setAmount(buyerItem.getAmount());
               }
               else {
                   shopCar.add(buyerItem);

               }
           }
       }
       else {


           shopCar.add(buyerItem);
       }





    }

    public static List<BuyerItem> getShopCar() {
        return shopCar;
    }

    public static void setShopCar(List<BuyerItem> shopCar) {
        Shopcar.shopCar = shopCar;
    }

    //商品数量
    public static Integer getProductAmount(){

        Integer result = 0;

        for (BuyerItem b:shopCar) {
            result += b.getAmount();
        }

        return result;

    }

    //商品价格
    public static float getProductPrice(){
        Float price = null;
        for (BuyerItem b:shopCar) {
         //   System.out.println(b.getAmount());
            price +=((Float.parseFloat(b.getAmount().toString()))*b.goods.getGprice());

        }

        return  price;
    }
    //商品总价打折后的真实价格
    public static   float getTotalPrice(){
        float price = 0;
     //   System.out.println(shopCar);
        for (BuyerItem b:shopCar) {
            //price =Float.parseFloat("0.0") ;
            //System.out.println(b.getAmount());=(Float.parseFloat(b.getAmount().toString()))*
            price +=(Float.parseFloat(b.getAmount().toString()))*b.goods.getGprice()*b.goods.getGdiscount();

        }

        return  price;


    }


}