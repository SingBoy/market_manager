package com.sigal.core.service;



import com.sigal.common.pagination.model.PaginationList;
import com.sigal.core.model.User;

import java.util.List;

public interface UserService {

	public PaginationList<User> list(User user);

	public User login(String username, String password);

	public User get(Integer id);

	public boolean saveOrUpdate(User user);

	public boolean delete(Integer id);

	public boolean enable(Integer id);

	public Boolean selectByUsername(User user);

	public List<User> getByBusinessId(Integer id);

	public boolean batchDelete(Integer[] ids);

	public List<User> selectBusinessList();

	public int updateBusiness(User user);

	public int updatePassword(User user);

	public int editPassWordDefault(Integer id);

	public int selectByUsernameAndRole(String username, String role);
}
