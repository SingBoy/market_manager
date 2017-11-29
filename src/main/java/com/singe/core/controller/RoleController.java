package com.singe.core.controller;


import com.singe.common.controller.BaseController;
import com.singe.common.pagination.model.PaginationList;
import com.singe.common.utils.ConstantConfig;
import com.singe.core.model.*;
import com.singe.core.model.Role;
import com.singe.core.service.AccountRoleService;
import com.singe.core.service.MenuService;
import com.singe.core.service.RoleMenuService;
import com.singe.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
	@Autowired
	private AccountRoleService accountRoleService;

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
	public String doMenuForm(@PathVariable Integer id, HttpSession session, Role queryQuery, ModelMap modelMap) {
		//Role role = roleService.get(id);
		Account account = (Account) session.getAttribute(ConstantConfig.ACCOUNT);
		if(account!=null){
			List<AccountRole> roleList = accountRoleService.selectListByAccountId(account.getId());
			if(roleList!=null&&!roleList.isEmpty()){
				//查询所有菜单
				List<Map<Menu,List<Menu>>> menuMapList = menuService.selectAllLevelsMenu();
				//查询当前用户的所有菜单
				List<RoleMenu> roleMenus = roleMenuService.selectListByRoleId(roleList.get(0).getId());
				List<Integer> menus = new ArrayList<>();
				if(roleMenus!=null&&roleMenus.size()>0){
					for(RoleMenu rm:roleMenus){
						menus.add(rm.getMenuId());
					}
				}
				modelMap.put(ConstantConfig.QUERYBEAN,queryQuery);
				modelMap.put("role", roleList.get(0));
				modelMap.put("menuMapList", menuMapList);
				modelMap.put("menus", menus);
				return "pager/role/menuform";
			}

		}else{
			return "redirect:/login";
		}
		return "";
	}
	//

}
