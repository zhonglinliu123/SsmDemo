package com.zlin.mapper;

import com.zlin.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAllUser();

    void insertUser(User user);

    void deleteUser(User user);

    User selectUserById(User user);

    List<User> selectUserByName(User user);
}
