package com.sigal.core.controller;


import com.sigal.common.controller.BaseController;
import com.sigal.common.pagination.model.PaginationList;
import com.sigal.common.utils.ConstantConfig;
import com.sigal.core.model.Menu;
import com.sigal.core.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/list")
	public String login(Menu queryBean,ModelMap modelMap, HttpServletResponse response) {
		PaginationList<Menu> pageDataList = menuService.list(queryBean);
		modelMap.put(ConstantConfig.PAGE_DATA_LIST,pageDataList);
		modelMap.put(ConstantConfig.QUERYBEAN,queryBean);
		return "pager/menu/list";
	}

	@RequestMapping(value = "/doAdd")
	public String doAdd(Menu queryQuery, ModelMap modelMap) {
		modelMap.put(ConstantConfig.QUERYBEAN,queryQuery);
		List<Menu> firstMenuList = menuService.selectFirstMenuList();
		modelMap.put("firstMenuList",firstMenuList);
		return "pager/menu/form";
	}

	@RequestMapping(value = "/doEdit/{id}")
	public String doEdit(@PathVariable Integer id, Menu queryBean, ModelMap modelMap) {
		Menu menu = menuService.get(id);
		modelMap.put("menu", menu);
		List<Menu> firstMenuList = menuService.selectFirstMenuList();
		modelMap.put("firstMenuList",firstMenuList);
		modelMap.put(ConstantConfig.QUERYBEAN, queryBean);
		return "pager/menu/form";
	}

	@RequestMapping(value = "/saveOrUpdate")
	public String saveOrUpdate(Menu queryBean, ModelMap modelMap) throws UnsupportedEncodingException {
		int count = menuService.saveOrUpdateMenu(queryBean);
		modelMap.put(ConstantConfig.QUERYBEAN, queryBean);
		return "redirect:/menu/list?keyword="+(java.net.URLEncoder.encode(queryBean.getKeyword(),"UTF-8"))+"&currentPage="+queryBean.getCurrentPage()+"&pageSize="+queryBean.getPageSize();
	}

	@RequestMapping(value = "/deleteById/{id}")
	public String deleteById(@PathVariable Integer id, Menu queryBean, ModelMap modelMap) throws UnsupportedEncodingException {
		int count = menuService.deleteById(id);
		modelMap.put(ConstantConfig.QUERYBEAN, queryBean);
		return "redirect:/menu/list?keyword="+(java.net.URLEncoder.encode(queryBean.getKeyword(),"UTF-8"))+"&currentPage="+queryBean.getCurrentPage()+"&pageSize="+queryBean.getPageSize();
	}
}
