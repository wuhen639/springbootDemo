package com.jmd.springboot.service;

import com.jmd.springboot.dao.UserMapper;
import com.jmd.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by mengtongzhou1 on 2016/12/22.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Transactional
    public void updateUser(User u1){
        try {
            userMapper.updateById(u1);
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void updateUser2(User u1){


        try {
            userMapper.updateById(u1);
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    @Transactional(readOnly = true)
    public User selectUser(Integer id){
        User u= null;
        try {
//
            List<User> u2=userMapper.selectById(id);

            if(null!=u2&&u2.size()>0)u=u2.get(0);
////            Thread.sleep(5000);
////            User u3=userMapper.selectById(2);
////            u2.setName("nana3");
////            userMapper.updateById(u3);
//
                            Thread.sleep(3000);

//
//
//
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Transactional(readOnly = true)
    public User selectUserRead(Integer id){
       // User u=userMapper.selectById(id);
//        return u;


        return null;
    }




    @Transactional
    public void addUser(User u1){

        User u=new User();
        u.setName("222");
        userMapper.save(u);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Transactional
    public void testLocK1(User u1){

        User u=new User();
        u.setId(2);
        u.setName("222");
        userMapper.save(u);
    }

    @Transactional
    public void testRW(User u1){
        //测试先读后写是否锁定
        try {
            List<User> ul=userMapper.selectById(1);
            User u2=new User();
            u2.setId(2);
            u2.setAge(444);
            u2.setName("ddd");
            userMapper.updateById(u2);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
