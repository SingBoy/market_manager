package com.singe.core.service.impl;


import com.singe.core.dao.RoleMenuMapper;
import com.singe.core.model.RoleMenu;
import com.singe.core.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
