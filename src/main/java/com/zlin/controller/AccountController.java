package com.zlin.controller;

import com.zlin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/accountBalance", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public void accountBalance(@RequestBody Map<String,Object> models) {
        Integer lessId = (Integer) models.get("lessId");
        Integer addId = (Integer) models.get("addId");
        Double balance = (Double) models.get("balance");
        accountService.accountBalance(lessId, addId, balance);
    }
}
