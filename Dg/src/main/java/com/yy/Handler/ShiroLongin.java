package com.yy.Handler;



import com.yy.POJO.Users;
import com.yy.Service.RegisterService;
import com.yy.Util.EmailUtils;
import com.yy.Util.MD5;
import com.yy.Util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.sun.jmx.snmp.ThreadContext.contains;
import static java.lang.System.out;

/**
 * @author 袁毅
 * @date 2018/10/13 0013-下午 8:21
 */
@Controller
@RequestMapping("/shiro")
@SessionAttributes(value = {"uName"},types = {String.class})
public class ShiroLongin{
    @Autowired
    RegisterService registerService;

    @Autowired
    private JavaMailSender javaMailSender;// 在spring中配置的邮件发送的bean

    @RequestMapping(value = "/longins",method = RequestMethod.POST)
    public ModelAndView longin(@RequestParam("uname") String uname, @RequestParam("psword") String pwword, @RequestParam(value = "rememberMe",defaultValue = "true",required = false)boolean b, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) {

        Subject currentUser = SecurityUtils.getSubject();

        if(!currentUser.isAuthenticated()){
            //将用户名封装成UsernamePasswordToken
            UsernamePasswordToken token = new UsernamePasswordToken(uname,pwword);
            //记住我
            if (b == true) {
            out.println("ShiroLongin--->"+b);

            token.setRememberMe(true);}
            try {

                currentUser.login(token);
            }
            catch (AuthenticationException as){
                out.println("登录失败"+as.getMessage());
            }

        }

        //将服务器会话id写入cookie发回游览器，用于用户认证
       // Cookie cookie = new Cookie("user",httpServletRequest.getSession().getId());
       // cookie.setPath("/");
       // cookie.setMaxAge(-1);
       // httpServletResponse.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("uName",uname);

        modelAndView.setViewName("redirect:/show/good");
        return modelAndView;
    }

    @RequestMapping(value = "Register",method = RequestMethod.POST)
    public ModelAndView EmailRegister(ModelAndView modelAndView,@RequestParam(value = "email",defaultValue = "false",required = false) String email,@RequestParam(value = "password",defaultValue = "false",required = false) String password){

        int a = registerService.UserRegister(email.substring(0,5),new MD5().mm(password,email.substring(0,5)),email,email.substring(0,5));
        //email.substring(0,5)标识用户名和昵称

        Users users = new Users(email.substring(0,5),password,email,email.substring(0,5));

        modelAndView.setViewName("redirect:/static/home/longin.jsp");

        return  modelAndView;





    }

    @RequestMapping("/hhh")
    @RequiresPermissions("user:great")
    public String h(){
        out.println("进来了");
        return "success";
    }


    @RequestMapping("/Email")
    @ResponseBody
    public Map<String,String> ajaxEmailSend(@RequestBody Users users) {
        //System.out.println(email);
        String numBer =String.valueOf((int) (Math.random()*1000000)) ;
        System.out.println(numBer);
        EmailUtils emailUtils = new EmailUtils();



        emailUtils.sendMail(numBer, "一封来自代购网站的邮件", "D:/abcs.jpg",users.getEmail(),
               javaMailSender, false);

        Map<String,String> stringMap = new HashMap<>();
        //产生随机数


        stringMap.put("Em",numBer);
        return stringMap;
    }



}
