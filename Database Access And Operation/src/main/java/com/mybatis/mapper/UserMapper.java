package com.mybatis.mapper;

import com.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();
    //根据id查询用户
    User getUserById(int id);
    //模糊查询
    User getUserLikeName(String value);
    //添加用户
    int addUser(User user);
    int addUser2(Map<String, Object> map);
    //更改用户
    int updateUser(User user);
    //删除用户
    int deleteUser(int id);
}

