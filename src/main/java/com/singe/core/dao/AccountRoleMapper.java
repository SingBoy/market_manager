package com.singe.core.dao;

import com.singe.core.model.AccountRole;

import java.util.List;

public interface AccountRoleMapper {

    List<AccountRole> selectListByAccountId(Integer accountId);

    int deleteByPrimaryKey(Integer id);

    int insertBatchSelective(List<AccountRole> accountRoleList);

}