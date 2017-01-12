package com.jmd.springboot.dao;

import com.jmd.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * Created by mengtongzhou1 on 2016/12/18.
 */
@Mapper
public interface UserMapper {

    int save(User user);

    List<User> selectById(Integer id);

    int updateById(User user);

    int deleteById(Integer id);

    List<User> queryAll();
}
