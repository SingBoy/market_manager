package com.sigal.core.service.impl;


import com.sigal.common.pagination.model.PaginationList;
import com.sigal.common.pagination.model.SimplePaginatedList;
import com.sigal.core.dao.RoleMapper;
import com.sigal.core.dao.RoleMenuMapper;
import com.sigal.core.model.Role;
import com.sigal.core.model.RoleMenu;
import com.sigal.core.service.RoleMenuService;
import com.sigal.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@Override
	public List<RoleMenu> selectListByRoleId(Integer roleId) {
		return roleMenuMapper.selectListByRoleId(roleId);
	}

	@Override
	public int deleteById(Integer id) {
		return roleMenuMapper.deleteByPrimaryKey(id);
	}


}
