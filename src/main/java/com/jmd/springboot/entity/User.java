package com.jmd.springboot.entity;

import java.io.Serializable;

/**
 * Created by mengtongzhou1 on 2016/12/18.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 8809101560720973267L;

    private Integer id;

    private String name;

    private Integer age;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }


}