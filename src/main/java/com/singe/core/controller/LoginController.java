package com.singe.core.controller;


import com.singe.common.controller.BaseController;
import com.singe.common.utils.ConstantConfig;
import com.singe.common.utils.MD5Util;
import com.singe.core.model.Account;
import com.singe.core.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String accountname,
			@RequestParam String password, HttpSession session,
			ModelMap modelMap,HttpServletResponse response) {
		try {
			if (StringUtils.isBlank(accountname) || StringUtils.isBlank(password)) {
				throw new RuntimeException("账户或密码不能为空!");
			}
			Account account = accountService.login(accountname, password);
			if (null != account) {
				// 1、创建cookie
				accountname = URLEncoder.encode(accountname, "utf-8");
				Cookie usernameCookie = new Cookie("accountname", accountname);
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
				String now = sdf.format(date);
				Cookie dateCookie = new Cookie("date", now);

				Cookie passwordCookie = new Cookie("password", password);
				// 2、设置cookie的过期时间，如果不设置，则浏览关闭后就过期了，本地就没有了
				usernameCookie.setMaxAge(30 * 24 * 3600);
				dateCookie.setMaxAge(30 * 24 * 3600);
				passwordCookie.setMaxAge(30 * 24 * 3600);
				// 3、将cookie存于响应对象中
				response.addCookie(usernameCookie);
				response.addCookie(dateCookie);
				response.addCookie(passwordCookie);
				
				session.setAttribute(ConstantConfig.UID, account.getId());
				session.setAttribute(ConstantConfig.ACCOUNT, account);
			} else {
				//throw new RuntimeException("账户不存在!");
				modelMap.put(ConstantConfig.ERROR_MESSAGES, "账户不存在");
			}
			return "redirect:/welcome/index";
		} catch (Exception e) {
			modelMap.put(ConstantConfig.ERROR_MESSAGES, e.getMessage());
			return "login";
		}
	}

	@RequestMapping("/login")
	public String login(ModelMap modelMap) {
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (null != session) {
			session.invalidate();
		}
		return "redirect:/login";
	}

	@RequestMapping("/updatePassword")
	public String updatePassword(HttpSession session,ModelMap modelMap,@RequestParam String password,@RequestParam String pwdAgain) {
		if (null != session) {
			Account account = new Account();
			account = (Account) session.getAttribute(ConstantConfig.ACCOUNT);
			if(password.equals(pwdAgain)){
				account.setPassword(MD5Util.MD5(password));
				accountService.updatePassword(account);
			}else{
				modelMap.put(ConstantConfig.ERROR_MESSAGES, "两次密码输入不一致!");
			}
		}
		return "redirect:/login";
	}

}
