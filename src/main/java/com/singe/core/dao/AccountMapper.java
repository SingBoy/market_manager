package com.singe.core.dao;

import com.singe.core.model.Account;

import java.util.List;

public interface AccountMapper {
    public Account selectByAccountname(String accountname);

    public int updatePassword(Account account);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Account account);

    int updateByPrimaryKeySelective(Account account);

    Account selectByPrimaryKey(Integer id);

    public Integer selectCount(Account queryBean);

    public List<Account> selectList(Account queryBean);

}