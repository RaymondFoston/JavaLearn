package com.example.mybatis_plus_demo.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis_plus_demo.entity.User;
import com.example.mybatis_plus_demo.mapper.UserMapper;
import com.example.mybatis_plus_demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
