package com.sigal.core.service;



import com.sigal.common.pagination.model.PaginationList;
import com.sigal.core.model.Account;
import com.sigal.core.model.Menu;
import com.sigal.core.model.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface RoleService {

	public PaginationList<Role> list(Role queryBean);

	public Role get(Integer id);

	public int saveOrUpdateRole(Role role);

	public int deleteById(Integer id);

	public List<Role> selectNoPageRole(String companyId);
}
