package com.yy.shiro;

import com.yy.DAO.UsersMapper;
import com.yy.POJO.Users;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 袁毅
 * @date 2018/10/12 0012-下午 6:18
 */
public class FristRealm extends AuthorizingRealm {
    @Autowired
    UsersMapper userMapper;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {


        //1.把AuthenticationInfo 转换为 UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //从UsernamePasswordToken中获取username
        String username = usernamePasswordToken.getUsername();
        Boolean b = username.contains("@");
        Users user;
        if(!b){//判断username是用户名还是email
        //调用数据库的方法，从数据库中查询username对应的用户记录
        user = userMapper.selectByName(username,"");}
        else{

            user = userMapper.selectByName("",username);
        }
        //若用户不存在，则可以抛出
        if ("".equals(username)){

            throw  new UnknownAccountException("用户不存在");

        }
        //根据用户情况，决定是否抛出其他的AuthenticationException异常
        if (0 == user.getValid()){
            throw new LockedAccountException("用户被锁定");
        }
        //根据用户的情况，来构造AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
        //principal认证的实体信息，可以是username,前台传过来的对象
        Object principal = username;
        //对应的盐值
        ByteSource byteSource = null;
        Object credentials = null;
        if(!b){//对应的盐值
            if(username.equals(user.getUname())){
                byteSource = ByteSource.Util.bytes(user.getUname());
                //credentials：密码
                credentials  = user.getPsword();
            }
        }
        else {
            //对应的盐值
            if(username.equals(user.getEmail())){
                byteSource = ByteSource.Util.bytes(user.getUname());
                //credentials：密码
                credentials  = user.getPsword();
            }
        }

        System.out.println(user);
        //realmName: 当前realm对象的name,调用父类的getName方法
        String realmName = getName();

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,byteSource,realmName);


        return info;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.从PrincipalCollection获取用户信息
        Object user = principalCollection.toString();


        System.out.println("AuthorizationInfo-->  "+user);
        //2.从登陆的用户信息查询当前的权限和角色，可能需要查询数据库
        Set<String> roles  = new HashSet<>();

        if("admin".equals(user)){
            roles.add("admin");
        }
        //3.创建SimpleAuthorizationInfo实例，设置reles（角色）属性，返回此对象
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        simpleAuthorizationInfo.addStringPermission("user:great");
        return simpleAuthorizationInfo;
    }
}

