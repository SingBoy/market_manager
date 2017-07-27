package com.sigal.core.controller;


import com.sigal.common.controller.BaseController;
import com.sigal.common.pagination.model.PaginationList;
import com.sigal.common.utils.ConstantConfig;
import com.sigal.core.model.*;
import com.sigal.core.model.Role;
import com.sigal.core.service.MenuService;
import com.sigal.core.service.RoleMenuService;
import com.sigal.core.service.RoleService;
import com.sigal.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private RoleMenuService roleMenuService;

	@RequestMapping(value = "/list")
	public String login(Role queryBean,ModelMap modelMap, HttpServletResponse response) {
		PaginationList<Role> pageDataList = roleService.list(queryBean);
		modelMap.put(ConstantConfig.PAGE_DATA_LIST,pageDataList);
		modelMap.put(ConstantConfig.QUERYBEAN,queryBean);
		return "pager/role/list";
	}
	@RequestMapping(value = "/doAdd")
	public String doAdd(Role queryQuery, ModelMap modelMap) {
		modelMap.put(ConstantConfig.QUERYBEAN,queryQuery);
		return "pager/role/form";
	}

	@RequestMapping(value = "/doEdit/{id}")
	public String doEdit(@PathVariable Integer id, Role queryBean, ModelMap modelMap) {
		Role role = roleService.get(id);
		modelMap.put("role", role);
		modelMap.put(ConstantConfig.QUERYBEAN, queryBean);
		return "pager/role/form";
	}

	@RequestMapping(value = "/saveOrUpdate")
	public String saveOrUpdate(Role queryBean, ModelMap modelMap, HttpServletRequest request) throws UnsupportedEncodingException {
		queryBean.setCompanyId(getCurrentCompantId(request));
		int count = roleService.saveOrUpdateRole(queryBean);
		modelMap.put(ConstantConfig.QUERYBEAN, queryBean);
		return "redirect:/role/list?keyword="+(java.net.URLEncoder.encode(queryBean.getKeyword(),"UTF-8"))+"&currentPage="+queryBean.getCurrentPage()+"&pageSize="+queryBean.getPageSize();
	}

	@RequestMapping(value = "/deleteById/{id}")
	public String deleteById(@PathVariable Integer id, Role queryBean, ModelMap modelMap) throws UnsupportedEncodingException {
		int count = roleService.deleteById(id);
		modelMap.put(ConstantConfig.QUERYBEAN, queryBean);
		return "redirect:/role/list?keyword="+(java.net.URLEncoder.encode(queryBean.getKeyword(),"UTF-8"))+"&currentPage="+queryBean.getCurrentPage()+"&pageSize="+queryBean.getPageSize();
	}

	@RequestMapping(value = "/doMenuForm/{id}")
	public String doMenuForm(@PathVariable Integer id,Role queryQuery, ModelMap modelMap) {
		Role role = roleService.get(id);
		//查询所有菜单
		List<Map<Menu,List<Menu>>> menuMapList = menuService.selectAllLevelsMenu();
		//查询当前用户的所有菜单
		List<RoleMenu> roleMenus = roleMenuService.selectListByRoleId(role.getId());
		List<Integer> menus = new ArrayList<>();
		if(roleMenus!=null&&roleMenus.size()>0){
			for(RoleMenu rm:roleMenus){
				menus.add(rm.getMenuId());
			}
		}
		modelMap.put(ConstantConfig.QUERYBEAN,queryQuery);
		modelMap.put("role", role);
		modelMap.put("menuMapList", menuMapList);
		modelMap.put("menus", menus);
		return "pager/role/menuform";
	}
	//

}
