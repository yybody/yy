package com.yy.Handler;

import com.github.pagehelper.PageHelper;
import com.yy.POJO.Goods;
import com.yy.POJO.Menu1;
import com.yy.POJO.Menu2;
import com.yy.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 袁毅
 * @date 2018/12/13 0013-下午 2:09
 */

@Controller
@SessionAttributes(value = {"myGood","menu1","menu2"},types = {Goods.class,Menu1.class,Menu2.class})
@RequestMapping("/show")
public class HomePage {

    @Autowired
    HomeService homeService;

    @RequestMapping(value = "/good")//className:2级菜单份类名
    public ModelAndView showGood(){
        ModelAndView modelAndView = new ModelAndView();
        //查询之前传入页码和当前页面的消息条数
        //PageHelper.startPage(pn,5);

        List<Menu1> menu1List = homeService.getMenu1();
        List<Menu2> menu2List = homeService.getMenu2();

        List<Goods> goodsList = homeService.getHome();
        modelAndView.addObject("menu1",menu1List);
        modelAndView.addObject("menu2",menu2List);
        modelAndView.addObject("myGood",goodsList);
        modelAndView.setViewName("redirect:/static/home/home.jsp");


        return modelAndView;
    }



}
