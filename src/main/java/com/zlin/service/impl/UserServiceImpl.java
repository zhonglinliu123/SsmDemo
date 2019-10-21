package com.zlin.service.impl;

import com.zlin.mapper.UserMapper;
import com.zlin.pojo.User;
import com.zlin.service.UserService;
import com.zlin.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JacksonUtil jacksonUtil;

    @Override
    public String selectAllUser() {
        return jacksonUtil.bean2Json(userMapper.selectAllUser());
    }

    @Override
    public void insertUser(User user){
        userMapper.insertUser(user);
    }

    @Override
    public void deleteUser(User user){
        userMapper.deleteUser(user);
    }

    @Override
    public String selectUserById(User user){
        return jacksonUtil.bean2Json(userMapper.selectUserById(user));
    }

    @Override
    public String selectUserByName(User user){
        return jacksonUtil.bean2Json(userMapper.selectUserByName(user));
    }
}

