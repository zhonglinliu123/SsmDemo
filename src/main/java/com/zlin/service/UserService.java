package com.zlin.service;

import com.zlin.pojo.User;

public interface UserService {

    String selectAllUser();

    void insertUser(User user);

    void deleteUser(User user);

    String selectUserById(User user);

    String selectUserByName(User user);
}
