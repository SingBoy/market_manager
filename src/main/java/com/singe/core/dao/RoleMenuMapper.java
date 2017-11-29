package com.singe.core.dao;

import com.singe.core.model.RoleMenu;

import java.util.List;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(Integer id);

    List<RoleMenu> selectListByRoleId(Integer roleId);
}