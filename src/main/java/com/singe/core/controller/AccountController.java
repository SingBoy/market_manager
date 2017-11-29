package com.singe.core.controller;

import com.singe.common.pagination.model.PaginationList;
import com.singe.common.utils.ConstantConfig;
import com.singe.core.model.Account;
import com.singe.core.model.AccountRole;
import com.singe.core.model.Role;
import com.singe.core.service.AccountRoleService;
import com.singe.core.service.AccountService;
import com.singe.core.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Singe on 2017/7/22.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AccountRoleService accountRoleService;

    @RequestMapping(value = "/list")
    public String login(Account queryBean, ModelMap modelMap) {
        PaginationList<Account> pageDataList = accountService.list(queryBean);
        modelMap.put(ConstantConfig.PAGE_DATA_LIST,pageDataList);
        modelMap.put(ConstantConfig.QUERYBEAN,queryBean);
        return "pager/account/list";
    }

    @RequestMapping(value = "/doAdd")
    public String doAdd(Account queryQuery, ModelMap modelMap) {
        modelMap.put(ConstantConfig.QUERYBEAN,queryQuery);
        return "pager/account/form";
    }

    @RequestMapping(value = "/doEdit/{id}")
    public String doEdit(@PathVariable  Integer id, Account queryBean, ModelMap modelMap) {
        Account account = accountService.get(id);
        modelMap.put("account", account);
        modelMap.put(ConstantConfig.QUERYBEAN, queryBean);
        return "pager/account/form";
    }

    @RequestMapping(value = "/saveOrUpdate")
    public String saveOrUpdate(Account queryBean, ModelMap modelMap) throws UnsupportedEncodingException {
        int count = accountService.saveOrUpdateAccount(queryBean);
        modelMap.put(ConstantConfig.QUERYBEAN, queryBean);
        return "redirect:/account/list?keyword="+(java.net.URLEncoder.encode(queryBean.getKeyword(),"UTF-8"))+"&currentPage="+queryBean.getCurrentPage()+"&pageSize="+queryBean.getPageSize();
    }

    @RequestMapping(value = "/deleteById/{id}")
    public String deleteById(@PathVariable Integer id, Account queryBean, ModelMap modelMap) throws UnsupportedEncodingException {
        int count = accountService.deleteById(id);
        modelMap.put(ConstantConfig.QUERYBEAN, queryBean);
        return "redirect:/account/list?keyword="+(java.net.URLEncoder.encode(queryBean.getKeyword(),"UTF-8"))+"&currentPage="+queryBean.getCurrentPage()+"&pageSize="+queryBean.getPageSize();
    }

    @RequestMapping(value = "/doRoleForm/{id}")
    public String doRoleForm(@PathVariable Integer id,Account queryQuery, ModelMap modelMap) {
        Account account = accountService.get(id);
        //查询所有角色
        List<Role> roles  = roleService.selectNoPageRole("");
        //查询当前用户的所有角色
        List<AccountRole> accountRoles = accountRoleService.selectListByAccountId(account.getId());
        List<Integer> roleIds = new ArrayList<>();
        if(accountRoles!=null&&accountRoles.size()>0){
            for(AccountRole ac:accountRoles){
                roleIds.add(ac.getRoleId());
            }
        }

        modelMap.put(ConstantConfig.QUERYBEAN,queryQuery);
        modelMap.put("account", account);
        modelMap.put("roles", roles);
        modelMap.put("roleIds", roleIds);
        return "pager/account/roleform";
    }

    @RequestMapping(value = "/saveOrUpdateRole")
    @ResponseBody
    public boolean saveOrUpdateRole(@Param("roleIds") String roleIds, @Param("accountId") Integer accountId){
        int count = accountRoleService.saveOrUpdateAccountRole(roleIds,accountId);
        if(count>0){
            return true;
        }
        return false;
    }

}
