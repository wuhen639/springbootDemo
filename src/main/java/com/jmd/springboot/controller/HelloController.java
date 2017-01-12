package com.jmd.springboot.controller;

import com.jmd.springboot.entity.User;
import com.jmd.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@Controller
public class HelloController {
    private static int uid=0;
    @Autowired
    private UserService userService;

    @RequestMapping("/index/{link:.+}")
    public String index(Map<String, Object> map, @PathVariable String link) {

        URL url;
        try {
            link = "http://" + link;
            url = new URL(link);
            InputStream in = url.openStream();
            map.put("link", link + "链接可用");
            return "welcome";

        } catch (Exception e1) {
            map.put("link", link + "连接打不开");
            return "welcome";
        }
    }

    //测试mysql show full processlist中sleep的值
    @RequestMapping("/show")
    public String index(Map<String, Object> map) {
        try {
            for (int i = 0; i < 100; i++) {
                uid=i;
                Thread d = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        userService.selectUser(uid);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Date currentTime = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String dateString = formatter.format(currentTime);
                        System.out.println(dateString + "线程：" + Thread.currentThread().getName() + "查询完毕");
                    }
                }, String.valueOf(i));
                d.start();


            }

            return "user";

        } catch (Exception e1) {
            e1.printStackTrace();
            return "welcome";
        }

    }

    @RequestMapping("/show1")
    public String show1(Map<String, Object> map) {
        try {
            User u=userService.selectUser(1);
            map.put("user",u);
            return "user";
        } catch (Exception e1) {
            e1.printStackTrace();
            return "welcome";
        }

    }

    @RequestMapping("/testRW")
    public String testRW(Map<String, Object> map) {
        try {
           userService.testRW(null);
            return "user";
        } catch (Exception e1) {
            e1.printStackTrace();
            return "welcome";
        }

    }

    @RequestMapping("/update")
    public String update(Map<String, Object> map) {
        try {
//            User u=userService.selectUser(1);
//            u.setName("locklock");
            User u=new User();
            u.setId(1);
            u.setName("ddss");
            u.setAge(999);
            userService.updateUser(u);

            map.put("user",u);
            return "user";
        } catch (Exception e1) {
            e1.printStackTrace();
            return "welcome";
        }

    }
    @RequestMapping("/update2")
    public String update2(Map<String, Object> map) {
        try {

            User u=new User();
            u.setId(2);
            u.setName("fff");
            u.setAge(333);
            userService.updateUser2(u);

            map.put("user",u);
            return "user";
        } catch (Exception e1) {
            e1.printStackTrace();
            return "welcome";
        }

    }
    @RequestMapping("/show2")
    public String show2(Map<String, Object> map) {
        try {
            User u=userService.selectUserRead(1);
            map.put("user",u);
            return "user";
        } catch (Exception e1) {
            e1.printStackTrace();
            return "welcome";
        }

    }


    @RequestMapping("/add")
    public String add(Map<String, Object> map) {
        try {
            User u = new User();
            u.setAge(22);
            u.setName("张三11" + new Random().nextInt());
            userService.addUser(u);
            map.put("user", u);
            return "user";

        } catch (Exception e1) {
            e1.printStackTrace();
            return "welcome";
        }

    }

}