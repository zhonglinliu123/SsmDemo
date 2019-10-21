package com.zlin.service.impl;

import com.zlin.mapper.AccountMapper;
import com.zlin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Service("AccountService")  //业务层注解
// @Transactional //事务控制注解 加在类上表示对类中的所有方法
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void accountBalance(Integer lessId, Integer addId, Double balance) {
        accountMapper.lessBalance(lessId, balance);
        int i = 10/0;
        accountMapper.addBalance(addId, balance);
    }
}
