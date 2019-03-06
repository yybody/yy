package com.yy.shiro.Factroy;

import com.yy.DAO.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * @author 袁毅
 * @date 2018/10/17 0017-下午 6:41
 */
@Component
public class ShiroFactroy {
    @Autowired
    UsersMapper userMapper;
    public LinkedHashMap<String,String> get(){

        LinkedHashMap<String,String> map = new LinkedHashMap<>();


        map.put("/static/images/**","anon");
        map.put("/shiro/Register","anon");
        map.put("/static/AmazeUI-2.4.2/**","anon");
        map.put("/static/basic/**","anon");
        map.put("/static/css/**","anon");
        map.put("/static/js/**","anon");
        map.put("/static/home/longin.jsp","anon");
        map.put("/menu2/good","anon");
        map.put("/menu2/gid","anon");
        map.put("/index.jsp","anon");
        map.put("/alipay.trade.close.jsp","anon");
        map.put("/alipay.trade.fastpay.refund.query.jsp","anon");
        map.put("/alipay.trade.page.pay.jsp","anon");
        map.put("/alipay.trade.query.jsp","anon");
        map.put("/alipay.trade.refund.jsp","anon");
        map.put("/notify_url.jsp","anon");
        map.put("/return_url.jsp","anon");

        map.put("/static/home/introduction.jsp","anon");
        map.put("/static/home/home.jsp","anon");
        map.put("/static/home/register.jsp","anon");
        map.put("/static/home/search.jsp","anon");
        map.put("/static/person/password.jsp","anon");
        map.put("/static/home/shopcart.jsp","anon");
        map.put("/static/home/pay.jsp","anon");
        map.put("/shiro/longins","anon");
        map.put("/shop/Good","anon");
        map.put("http://api.map.baidu.com/place/v2/search","anon");
        map.put("/shop/goods","anon");
        map.put("/shop/check","anon");
        map.put("/show/good","anon");
        map.put("/shiro/Email","anon");
        map.put("/shiro/longout","logout");

        map.put("/user.jsp","authc,roles[user]");
        map.put("/admin.jsp","authc,roles[admin]");
        map.put("/**","authc");
        map.put("/list.jsp","perms[user:great]");


        return  map;
    }
}
