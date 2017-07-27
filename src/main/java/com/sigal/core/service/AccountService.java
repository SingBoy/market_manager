package com.sigal.core.service;


import com.sigal.common.pagination.model.PaginationList;
import com.sigal.core.model.Account;

public interface AccountService {

	public PaginationList<Account> list(Account account);

	public Account login(String accountname, String password);

	public Account get(Integer id);

	public int updatePassword(Account account);

	public int saveOrUpdateAccount(Account account);

	public int deleteById(Integer id);
}
