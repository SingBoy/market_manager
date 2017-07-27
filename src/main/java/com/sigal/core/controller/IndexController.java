package com.sigal.core.controller;


import com.sigal.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/welcome")
public class IndexController extends BaseController {
	

    @RequestMapping("/index")
	public String welcome(HttpSession session,ModelMap modelMap) {
		return "pager/index";
	}
}
