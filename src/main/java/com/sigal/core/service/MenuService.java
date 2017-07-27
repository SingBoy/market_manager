package com.sigal.core.service;

import com.sigal.common.pagination.model.PaginationList;
import com.sigal.core.model.Account;
import com.sigal.core.model.Menu;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/22.
 */
public interface MenuService {

    public PaginationList<Menu> list(Menu menuQuery);

    public Menu get(Integer id);

    public int saveOrUpdateMenu(Menu menu);

    public int deleteById(Integer id);

    public List<Menu> selectFirstMenuList();

    public List<Menu> selectSecondMenuList();

    public List<Map<Menu,List<Menu>>> selectAllLevelsMenu();
}

