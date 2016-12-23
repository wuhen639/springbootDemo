package com.jd.springboot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;


@Controller
public class HelloController {
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
}