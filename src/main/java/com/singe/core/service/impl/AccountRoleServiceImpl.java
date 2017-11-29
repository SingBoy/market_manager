package com.singe.core.service.impl;


import com.singe.core.dao.AccountRoleMapper;
import com.singe.core.model.AccountRole;
import com.singe.core.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {

	@Autowired
	private AccountRoleMapper accountRoleMapper;

	@Override
	public List<AccountRole> selectListByAccountId(Integer accountId) {
		return accountRoleMapper.selectListByAccountId(accountId);
	}

	@Override
	public int saveOrUpdateAccountRole(String roleIds, Integer accountId) {
		accountRoleMapper.deleteByPrimaryKey(accountId);
		//拆分成数组
		String [] strDisArray = roleIds.split("&");

		List<AccountRole> accountRoleList = new ArrayList<AccountRole>();
		Date nowDate = new Date();
		if(strDisArray !=null && strDisArray.length>0){
			AccountRole ar = null;
			for(int i = 0;i<strDisArray.length;i++) {
				ar = new AccountRole();
				ar.setAccountId(accountId);
				ar.setRoleId(Integer.valueOf(strDisArray[i]));
				ar.setCompanyId("");
				ar.setCreateDate(nowDate);
				accountRoleList.add(ar);
			}
		}
		int result = 0;
		if(accountRoleList.size()>0){
			result = accountRoleMapper.insertBatchSelective(accountRoleList);
		}
		return result;
	}

	@Override
	public int deleteById(Integer id) {
		return accountRoleMapper.deleteByPrimaryKey(id);
	}
}
