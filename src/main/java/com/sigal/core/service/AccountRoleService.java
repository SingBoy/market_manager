package com.sigal.core.service;


import com.sigal.common.pagination.model.PaginationList;
import com.sigal.core.model.Account;
import com.sigal.core.model.AccountRole;

import java.util.List;

public interface AccountRoleService {

	public List<AccountRole> selectListByAccountId(Integer accountId);

	public int saveOrUpdateAccountRole(String roleIds, Integer accountId);

	public int deleteById(Integer id);
}
