package com.jmd.springboot.controller;

import com.jmd.springboot.Repository.StudentRepository;
import com.jmd.springboot.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by mengtongzhou1 on 2017/1/8.
 */
@Controller
public class MongoDBDemoController {

    @Resource
    private StudentRepository studentRepository;

    @RequestMapping("/mongoDbDemo")
    public void showStudent(Map stuMap){
        Student st1=new Student();
        st1.setId(1);
        st1.setName("张三");
        st1.setAge(33);
        st1.setSex(0);
        studentRepository.save(st1);

    }
}
