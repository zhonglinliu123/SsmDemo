package com.zlin.controller;

import com.zlin.pojo.User;
import com.zlin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/selectAllUser", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String selectAllUser() {
        return userService.selectAllUser();
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public void insertUser(@RequestBody User user) {
         userService.insertUser(user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

    // @RequestParam针对GET请求,URL后面拼接的参数   @RequestBody针对POST请求
    @RequestMapping(value = "/selectUserById", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String selectUserById(@RequestBody User user) {
        return userService.selectUserById(user);
    }

    @RequestMapping(value = "/selectUserByName", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String selectUserByName(@RequestBody User user) {
        System.out.println(user);
        return userService.selectUserByName(user);
    }
}
