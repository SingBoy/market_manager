package com.singe.core.service;



import com.singe.core.model.RoleMenu;

import java.util.List;

public interface RoleMenuService {

	public int deleteById(Integer id);

	public List<RoleMenu> selectListByRoleId(Integer roleId);
}
