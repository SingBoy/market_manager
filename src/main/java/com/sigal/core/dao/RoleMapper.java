package com.sigal.core.dao;

import com.sigal.core.model.Account;
import com.sigal.core.model.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Role record);

    int updateByPrimaryKeySelective(Role role);

    Role selectByPrimaryKey(Integer id);

    public Integer selectCount(Role queryBean);

    public List<Role> selectList(Role queryBean);

    public List<Role> selectNoPageRole(String companyId);
}