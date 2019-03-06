package com.yy.Handler;

import com.google.gson.Gson;
import com.yy.POJO.BuyerItem;

import com.yy.POJO.Goods;
import com.yy.POJO.Shopcar;
import com.yy.Service.GoodService;
import com.yy.Util.jsonUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.jdbc.Null;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


/**
 * @author 袁毅
 * @date 2018/11/28 0028-下午 4:00
 */
@Controller
@RequestMapping("/shop")
@SessionAttributes(value = {"shopCar","rl","totalPrices"},types = {Goods.class,Integer.class,String.class})

public class Shopping {

    @Autowired
    GoodService goodService;
    //检查库存
    @ResponseBody
    @RequestMapping(value = "/Good",method = RequestMethod.POST)
    public Map<String,String> checkGood(@RequestBody BuyerItem buyerItem, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @CookieValue( value = "shop",required = false) Cookie c){
        System.out.println(buyerItem);
        Map<String,String> map = new HashMap<>();
        //boolean b =  goodService.checkGood(buyerItem.getGoods().getQty());
        //判断有无登录
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated())
        {


            //判断cookie是否存在
            if (c==null){


                Shopcar.addCar(buyerItem);
                map.put("subtotal",buyerItem.getAmount()*buyerItem.getGoods().getGprice()*buyerItem.getGoods().getGdiscount()+"");//subtotal商品小计System.out.println(buyerItem.getAmount()*buyerItem.getGoods().getGprice());

                List<BuyerItem> shopCar = new ArrayList<>();//购物车
                shopCar = Shopcar.getShopCar();
                System.out.println(JSONArray.fromObject(shopCar)+"json");

                Cookie cookie = new Cookie("shop", JSONArray.fromObject(shopCar).toString());

                cookie.setMaxAge(-1);
                cookie.setPath("/");
                httpServletResponse.addCookie(cookie);

            }
            else {

                //购物车
                //从cookie里获取购物车
                List<BuyerItem> list  = new ArrayList<>();

                //JSONObject jsonObject = new JSONObject().fromObject(c.getValue());
                list = jsonUtil.jsons(JSONArray.fromObject(c.getValue()),new ArrayList<BuyerItem>());
                //   List<BuyerItem> s = (ArrayList<BuyerItem>)JSONObject.toBean(jsonObject);

                // List<BuyerItem> s = gson.fromJson(c.getValue(),new ArrayList<BuyerItem>().getClass());

                //放进购物车
                Shopcar.setShopCar(list);
                //添加购物车
                Shopcar.addCar(buyerItem);

                //计算出打折后的价格
                map.put("subtotal",buyerItem.getAmount()*buyerItem.getGoods().getGprice()*buyerItem.getGoods().getGdiscount()+"");
                //System.out.println(buyerItem.getAmount()*buyerItem.getGoods().getGprice()*buyerItem.getGoods().getGdiscount());
                map.put("totalPrices",Shopcar.getTotalPrice()+"");
                System.out.println(Shopcar.getTotalPrice()+"");
                // 将购物车写回cookie

                c.setValue(JSONArray.fromObject(Shopcar.getShopCar()).toString());
                //发回客户端
                httpServletResponse.addCookie(c);
            }

        }
        else{

            //开启基于数据库的购物车



        }





        return  map;
    }

    @ResponseBody
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public Map<String,String> checkGood(@RequestBody BuyerItem buyerItem){


        boolean b = goodService.checkGood((buyerItem.getAmount()),buyerItem.getGoods().getGid());
        Goods goods = goodService.getGood(buyerItem.getGoods().getGid());
        float i = (buyerItem.getAmount())*goods.getGprice()*goods.getGdiscount();
        Map<String,String> map = new HashMap<>();
        map.put("pd",b+"");

        map.put("je",i+"");
        return map;
    }

    @RequestMapping(value = "/goods",method = RequestMethod.GET)
    public ModelAndView getCar(@RequestParam("gid") Integer id,HttpServletResponse httpServletResponse,@RequestParam("rl") Integer rl, ModelAndView modelAndView, @SessionAttribute(value = "shopCar",required = false)List<Goods> session,@CookieValue(value = "shop",required = false)Cookie cookie){



        Goods goods = goodService.getGood(id);
        List<Goods> list = new ArrayList<>();
        if(session!=null){list.addAll(session);}

        list.add(goods);

        BuyerItem buyerItem = new BuyerItem();
        buyerItem.setAmount(rl);
        buyerItem.setGoods(goods);

        if (cookie==null){

            Shopcar.addCar(buyerItem);
            modelAndView.addObject("totalPrices",buyerItem.getAmount()*buyerItem.getGoods().getGprice()*buyerItem.getGoods().getGdiscount()+"");//subtotal商品小计System.out.println(buyerItem.getAmount()*buyerItem.getGoods().getGprice());

            List<BuyerItem> shopCar = new ArrayList<>();//购物车
            shopCar = Shopcar.getShopCar();
            System.out.println(JSONArray.fromObject(shopCar)+"json");

            cookie = new Cookie("shop", JSONArray.fromObject(shopCar).toString());

            cookie.setMaxAge(-1);
            cookie.setPath("/");
            httpServletResponse.addCookie(cookie);

        }else {

            List<BuyerItem> list1  = new ArrayList<>();

            //JSONObject jsonObject = new JSONObject().fromObject(c.getValue());
            list1 = jsonUtil.jsons(JSONArray.fromObject(cookie.getValue()),new ArrayList<BuyerItem>());
            //   List<BuyerItem> s = (ArrayList<BuyerItem>)JSONObject.toBean(jsonObject);

            // List<BuyerItem> s = gson.fromJson(c.getValue(),new ArrayList<BuyerItem>().getClass());

            //放进购物车
            Shopcar.setShopCar(list1);
            //添加购物车
            Shopcar.addCar(buyerItem);

            //计算出打折后的价格
            modelAndView.addObject("subtotal",buyerItem.getAmount()*buyerItem.getGoods().getGprice()*buyerItem.getGoods().getGdiscount()+"");
            //System.out.println(buyerItem.getAmount()*buyerItem.getGoods().getGprice()*buyerItem.getGoods().getGdiscount());
            modelAndView.addObject("totalPrices",Shopcar.getTotalPrice()+"");
            System.out.println(Shopcar.getTotalPrice()+"");
            // 将购物车写回cookie

            cookie.setValue(JSONArray.fromObject(Shopcar.getShopCar()).toString());
            //发回客户端
            httpServletResponse.addCookie(cookie);



        }

















        modelAndView.addObject("shopCar",list);
        modelAndView.setViewName("redirect:/static/home/shopcart.jsp");
        modelAndView.addObject("rl",rl);
        return modelAndView;
    }



}
