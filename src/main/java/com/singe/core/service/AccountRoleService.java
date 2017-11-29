package com.singe.core.service;


import com.singe.core.model.AccountRole;

import java.util.List;

public interface AccountRoleService {

	public List<AccountRole> selectListByAccountId(Integer accountId);

	public int saveOrUpdateAccountRole(String roleIds, Integer accountId);

	public int deleteById(Integer id);
}
