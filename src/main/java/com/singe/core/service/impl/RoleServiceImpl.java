package com.singe.core.service.impl;


import com.singe.common.pagination.model.PaginationList;
import com.singe.common.pagination.model.SimplePaginatedList;
import com.singe.core.dao.RoleMapper;
import com.singe.core.model.Role;
import com.singe.core.service.RoleService;
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
