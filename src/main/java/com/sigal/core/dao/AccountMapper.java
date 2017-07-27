package com.sigal.core.dao;

import com.sigal.core.model.Account;
import org.apache.ibatis.annotations.Param;

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