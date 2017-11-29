package com.singe.core.service.impl;


import com.singe.common.pagination.model.PaginationList;
import com.singe.common.pagination.model.SimplePaginatedList;
import com.singe.common.utils.MD5Util;
import com.singe.core.dao.UserMapper;
import com.singe.core.model.User;
import com.singe.core.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	private final static Integer USER_STATUS_LOCKED = 1;
	
	@SuppressWarnings("unused")
	private final static Integer USER_STATUS_OK = 2;
	
	@Override
	public User login(String username, String password) {
		User user = userMapper.selectUserByUsername(username);
		if (null != user) {
			if (user.getStatus() == USER_STATUS_LOCKED) {
				throw new RuntimeException("账户已经被管理员锁定，暂无法使用!");
			}
			if (!MD5Util.MD5(password).equalsIgnoreCase(user.getPassword())) {
				throw new RuntimeException("账户或密码有误，请重新输入...");
			}
			return user;
		}
		return null;
	}
	
	@Override
	public PaginationList<User> list(User user) {
			Integer totalCount = userMapper.selectCount(user);
			List<User> list = userMapper.selectList(user);
			SimplePaginatedList<User> pList = new SimplePaginatedList<User>(list, user.getCurrentPage(), user.getPageSize(), totalCount);
			return pList;
	}

	@Override
	public User get(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean saveOrUpdate(User user) {
		if (null != user.getId()) {
			User u = userMapper.selectByPrimaryKey(user.getId());
			BeanUtils.copyProperties(user, u);
			u.setModifyDate(new Date());
			return userMapper.updateByPrimaryKeySelective(u) > 0;
		} else {
			user.setPassword(MD5Util.MD5("111111"));
			user.setStatus(2);//默认为禁用状态
			user.setCreateDate(new Date());
			return userMapper.insertSelective(user) > 0;
		}
	}

	@Override
	public boolean delete(Integer id) {
		return userMapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public boolean batchDelete(Integer[] ids) {
		return userMapper.batchDeleteUser(ids) > 0;
	}

	@Override
	public boolean enable(Integer id) {
		User user = userMapper.selectByPrimaryKey(id);
		if (user.getStatus() == 1) {
			user.setStatus(2);
		} else {
			user.setStatus(1);
		}
		user.setModifyDate(new Date());
		return userMapper.updateByPrimaryKeySelective(user) > 0;
	}

	@Override
	public Boolean selectByUsername(User user) {
		Boolean b = false;
		List<User> list = new ArrayList<User>();
		if(user.getId() != null){
			User u = userMapper.selectByPrimaryKey(user.getId());
			if(u.getUsername().equals(user.getUsername())){
				b = true;
			}else{
				list = userMapper.selectByUsername(user.getUsername());
			}
		}else{
			list = userMapper.selectByUsername(user.getUsername());
		}
		
		if(list.size() == 0){
			b = true;
		}
		return b;
	}

	@Override
	public List<User> getByBusinessId(Integer id) {
		return userMapper.selectByBusinessId(id);
	}

	@Override
	public List<User> selectBusinessList() {
		return userMapper.selectBusinessList();
	}

	@Override
	public int updateBusiness(User userQuery) {
		return userMapper.updateBusiness(userQuery);
	}

	@Override
	public int updatePassword(User user) {
		return userMapper.updatePassword(user);
	}

	@Override
	public int editPassWordDefault(Integer id) {
		User user = new User();
		user.setId(id);
		user.setPassword(MD5Util.MD5("111111"));
		return userMapper.updatePassword(user);
	}

	@Override
	public int selectByUsernameAndRole(String username, String role) {
		return userMapper.selectByUsernameAndRole(username,role);
	}
}
