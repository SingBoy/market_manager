package com.sigal.core.dao;

import com.sigal.core.model.Account;
import com.sigal.core.model.AccountRole;

import java.util.List;

public interface AccountRoleMapper {

    List<AccountRole> selectListByAccountId(Integer accountId);

    int deleteByPrimaryKey(Integer id);

    int insertBatchSelective(List<AccountRole> accountRoleList);

}