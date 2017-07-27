package com.sigal.core.dao;

import com.sigal.core.model.Role;
import com.sigal.core.model.RoleMenu;

import java.util.List;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(Integer id);

    List<RoleMenu> selectListByRoleId(Integer roleId);
}