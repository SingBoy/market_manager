package com.singe.core.service;



import com.singe.common.pagination.model.PaginationList;
import com.singe.core.model.Role;

import java.util.List;

public interface RoleService {

	public PaginationList<Role> list(Role queryBean);

	public Role get(Integer id);

	public int saveOrUpdateRole(Role role);

	public int deleteById(Integer id);

	public List<Role> selectNoPageRole(String companyId);
}
