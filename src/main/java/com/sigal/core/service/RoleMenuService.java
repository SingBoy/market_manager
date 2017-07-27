package com.sigal.core.service;



import com.sigal.common.pagination.model.PaginationList;
import com.sigal.core.model.Role;
import com.sigal.core.model.RoleMenu;

import java.util.List;

public interface RoleMenuService {

	public int deleteById(Integer id);

	public List<RoleMenu> selectListByRoleId(Integer roleId);
}
