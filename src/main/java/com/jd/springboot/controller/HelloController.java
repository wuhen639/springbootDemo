package com.jd.springboot.controller;
import com.jd.springboot.entity.User;
import com.jd.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    private UserService userService;
    @RequestMapping("/index/{link:.+}")
    public String index(Map<String,Object> map,@PathVariable String link){

        URL url;
        try {
            link="http://"+link;
            url = new URL(link);
            InputStream in = url.openStream();
            map.put("link",link+"链接可用");
            return "welcome";

        } catch (Exception e1) {
            map.put("link",link+"连接打不开");
            return "welcome";
        }
    }

    @RequestMapping("/show")
    public String index(Map<String,Object> map){
        try {

            User u=userService.selectUser(1);
            map.put("user",u);
            return "user";

        } catch (Exception e1) {
            e1.printStackTrace();
            return "welcome";
        }

    }

}