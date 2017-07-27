package com.sigal.core.service.impl;


import com.sigal.common.pagination.model.PaginationList;
import com.sigal.common.pagination.model.SimplePaginatedList;
import com.sigal.common.utils.MD5Util;
import com.sigal.core.dao.AccountMapper;
import com.sigal.core.dao.RoleMapper;
import com.sigal.core.model.Account;
import com.sigal.core.model.Role;
import com.sigal.core.service.AccountService;
import com.sigal.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public PaginationList<Role> list(Role queryBean) {
			Integer totalCount = roleMapper.selectCount(queryBean);
			List<Role> list = roleMapper.selectList(queryBean);
			SimplePaginatedList<Role> pList = new SimplePaginatedList<Role>(list, queryBean.getCurrentPage(), queryBean.getPageSize(), totalCount);
			return pList;
	}

	@Override
	public Role get(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int saveOrUpdateRole(Role role) {
		if(role.getId()==null){
			role.setCreateDate(new Date());
			role.setModifyDate(new Date());
			return roleMapper.insertSelective(role);
		}else{
			role.setModifyDate(new Date());
			return roleMapper.updateByPrimaryKeySelective(role);
		}
	}

	@Override
	public int deleteById(Integer id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Role> selectNoPageRole(String companyId) {
		return roleMapper.selectNoPageRole(companyId);
	}
}
