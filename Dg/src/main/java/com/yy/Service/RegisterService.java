package com.yy.Service;

import com.yy.DAO.UsersMapper;
import com.yy.POJO.Users;
import com.yy.POJO.UsersExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 袁毅
 * @date 2018/11/21 0021-下午 10:14
 */
@Service
public class RegisterService {
    @Autowired
    UsersMapper usersMapper;

    public int UserRegister(String userName,String PassWord,String email,String nickename){

        Users users = new Users(userName,PassWord,email,nickename);
        System.out.println(userName);
        int a = usersMapper.insertSelective(users);


       return a;
    }

    public List<Users> getUser(String uName){

        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUnameEqualTo(uName);
        List<Users> list = usersMapper.selectByExample(usersExample);
        return  list;
    }


}
