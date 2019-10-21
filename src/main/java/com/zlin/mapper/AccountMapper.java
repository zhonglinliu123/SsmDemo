package com.zlin.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    void lessBalance(@Param("id") Integer id, @Param("balance") Double balance);

    void addBalance(@Param("id") Integer id, @Param("balance") Double balance);
}
