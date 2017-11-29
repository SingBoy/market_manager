package com.singe.core.service.impl;


import com.singe.common.pagination.model.PaginationList;
import com.singe.common.pagination.model.SimplePaginatedList;
import com.singe.common.utils.ConstantConfig;
import com.singe.core.dao.MenuMapper;
import com.singe.core.model.Menu;
import com.singe.core.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public PaginationList<Menu> list(Menu menuQuery) {
        Integer totalCount = menuMapper.selectCount(menuQuery);
        List<Menu> list = menuMapper.selectList(menuQuery);
        SimplePaginatedList<Menu> pList = new SimplePaginatedList<Menu>(list, menuQuery.getCurrentPage(), menuQuery.getPageSize(), totalCount);
        return pList;
    }

    @Override
    public Menu get(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveOrUpdateMenu(Menu menu) {
        if (menu.getId() == null) {
            menu.setCreateDate(new Date());
            menu.setModifyDate(new Date());
            return menuMapper.insertSelective(menu);
        } else {
            menu.setModifyDate(new Date());
            return menuMapper.updateByPrimaryKeySelective(menu);
        }
    }

    @Override
    public int deleteById(Integer id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Menu> selectFirstMenuList() {
        return menuMapper.selectNoPageList(ConstantConfig.MENU_FIRST);
    }

    @Override
    public List<Menu> selectSecondMenuList() {
       return  menuMapper.selectNoPageList(ConstantConfig.MENU_SECOND);
    }

    @Override
    public List<Map<Menu, List<Menu>>> selectAllLevelsMenu() {
        List<Map<Menu, List<Menu>>> menuListMapList = new ArrayList<>();
        Map<Menu, List<Menu>> menuMap = new HashMap<>();

        List<Menu> secondaryMenus = new ArrayList<>();
        Map<Integer, List<Menu>> secondMenuMap = new HashMap<>();

        List<Menu> secondMenus = selectSecondMenuList();
        //首先将二级菜单按照<id,menu>放到Map中,
        if (secondMenus != null && secondMenus.size() > 0) {
            for (Menu menu : secondMenus) {
                if(secondMenuMap.containsKey(menu.getParentId())){
                    secondMenuMap.get(menu.getParentId()).add(menu);
                }else{
                    secondaryMenus = new ArrayList<>();
                    secondaryMenus.add(menu);
                    secondMenuMap.put(menu.getParentId(),secondaryMenus);
                }
            }
        }
        List<Menu> firstMenus = selectFirstMenuList();
        //首先将一级菜单按照<id,menu>放到Map中,
        if (firstMenus != null && firstMenus.size() > 0) {
            for (Menu menu : firstMenus) {
                menuMap = new HashMap<>();
                if(secondMenuMap.containsKey(menu.getId())){
                    menuMap.put(menu,secondMenuMap.get(menu.getId()));
                    menuListMapList.add(menuMap);
                }else{
                    menuMap.put(menu,null);
                    menuListMapList.add(menuMap);
                }
            }
        }
        return menuListMapList;
    }
}
