package com.yy.Handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yy.DAO.GoodsMapper;
import com.yy.POJO.Goods;
import com.yy.Service.showGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 袁毅
 * @date 2018/12/16 0016-下午 4:40
 */
@Controller
@RequestMapping("/menu2")
@SessionAttributes(value = {"pageInfo","good"},types = {PageInfo.class,Goods.class})
public class ShowGood {
    @Autowired
    showGoodService showGoodService;

    @Autowired
    GoodsMapper goodsMapper;
    //页码
    @RequestMapping(value = "/good",method = RequestMethod.GET)
    public ModelAndView showGood(@RequestParam(value = "m2id",required = true) Integer m2id,@RequestParam(value = "pn",required = false,defaultValue = "1") Integer pn, ModelAndView modelAndView){
        PageHelper.startPage(pn,12);
        List<Goods> goodsList =  showGoodService.getGood(m2id);
        //指定分页的内容，及连续显示的页码
        PageInfo pageInfo = new PageInfo(goodsList,5);
        modelAndView.addObject("pageInfo",pageInfo);

        modelAndView.setViewName("redirect:/static/home/search.jsp");






        return modelAndView;
    }




    @RequestMapping(value = "/gid",method = RequestMethod.GET)
    public ModelAndView good(@RequestParam(value = "goodid") Integer id,ModelAndView modelAndView){

        Goods goods = goodsMapper.selectByPrimaryKey(id);
        modelAndView.setViewName("redirect:/static/home/introduction.jsp");
        modelAndView.addObject("good",goods);
        return  modelAndView;
    }

}
