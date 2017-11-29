package com.singe.core.dao;

import com.singe.core.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
	public User selectUserByUsername(String username);
	
	public List<User> selectByUsername(String username);

    public Integer selectCount(User queryBean);

    public List<User> selectList(User queryBean);

    List<User> selectByBusinessId(Integer id);

    int batchDeleteUser(Integer[] ids);

    public List<User> selectBusinessList();

    public int updateBusiness(User user);

    public int updatePassword(User user);

    public int editPassWordDefault(Integer id);

    public int selectByUsernameAndRole(@Param("username") String username, @Param("userRole") String role);
}