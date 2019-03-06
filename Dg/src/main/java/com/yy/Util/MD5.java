package com.yy.Util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author 袁毅
 * @date 2018/11/21 0021-下午 11:21
 */
public class MD5 {

    public MD5() {
    }

    public String  mm(String password,String uName){

        String name = "MD5";
        Object object1 = password;
        //盐子
        Object salt = ByteSource.Util.bytes(uName);
        int a = 1024;
        Object result = new SimpleHash(name,object1,salt,a);
        password = result.toString();
        return password;
    }

}
