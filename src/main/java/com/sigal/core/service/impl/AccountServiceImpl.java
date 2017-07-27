package com.sigal.core.service.impl;


import com.sigal.common.pagination.model.PaginationList;
import com.sigal.common.pagination.model.SimplePaginatedList;
import com.sigal.common.utils.ConstantConfig;
import com.sigal.common.utils.DateUtils;
import com.sigal.common.utils.MD5Util;
import com.sigal.core.dao.AccountMapper;
import com.sigal.core.model.Account;
import com.sigal.core.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public Account login(String accountname, String password) {
		Account account = accountMapper.selectByAccountname(accountname);
		if (null != account) {
			if (!MD5Util.MD5(password).equalsIgnoreCase(account.getPassword())) {
				throw new RuntimeException("账户或密码有误，请重新输入...");
			}
			return account;
		}
		return null;
	}


	
	@Override
	public PaginationList<Account> list(Account account) {
			Integer totalCount = accountMapper.selectCount(account);
			List<Account> list = accountMapper.selectList(account);
			SimplePaginatedList<Account> pList = new SimplePaginatedList<Account>(list, account.getCurrentPage(), account.getPageSize(), totalCount);
			return pList;
	}

	@Override
	public Account get(Integer id) {
		return accountMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updatePassword(Account account) {
			return accountMapper.updatePassword(account);
	}

	@Override
	public int saveOrUpdateAccount(Account account) {
		if(account.getId()==null){
			account.setPassword(MD5Util.MD5(ConstantConfig.DEFALUT_PASSWORD));
			account.setCreateDate(new Date());
			account.setModifyDate(new Date());
			return accountMapper.insertSelective(account);
		}else{
			account.setModifyDate(new Date());
			return accountMapper.updateByPrimaryKeySelective(account);
		}
	}

	@Override
	public int deleteById(Integer id) {
		return accountMapper.deleteByPrimaryKey(id);
	}
}
