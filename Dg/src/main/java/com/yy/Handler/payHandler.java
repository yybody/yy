package com.yy.Handler;

import com.yy.POJO.*;
import com.yy.Service.RegisterService;
import com.yy.Service.ddService;
import com.yy.Service.payService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author 袁毅
 * @date 2018/12/25 0025-下午 2:04
 */
@Controller
@RequestMapping("pay")
@SessionAttributes(value = {"logistics","myShopcar"},types = {Logistics.class, BuyerItem.class})
public class payHandler {

    @Autowired
    payService pay;
    @Autowired
    RegisterService registerService;
    @Autowired
    ddService dd;

    //用户支付
    @RequestMapping("good")
    public ModelAndView payGood(@SessionAttribute("user")String str,ModelAndView modelAndView){
        //支付
        List<Users> u =  registerService.getUser(str);
        pay.shopGood(u.get(0).getUid());

       //订单生成

        List<Logistics> logistics = dd.insertDD(u.get(0));
        modelAndView.addObject("map",logistics);

        modelAndView.setViewName("redirect:/static/home/success.jsp");

        return modelAndView;
     }



     //预支付页面
     public ModelAndView pay(@SessionAttribute("user")String str,ModelAndView modelAndView){

         modelAndView.addObject("myShopcar",Shopcar.getShopCar());

         modelAndView.setViewName("redirect:/static/home/pay.jsp");

         return modelAndView;
     }



}
