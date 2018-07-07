package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.User;
import com.xjtu.iqa.po.UserExample;

public interface UserMapper {
	int deleteByPrimaryKey(String USERID);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(String USERID);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	// 获取所有待审核用户_
	List<User> getAllUsers(int userstate);

	// 获取用户角色名
	String getRoleNameByUserId(String userId);

	//获取所有待审核用户_限定数量
	List<User> getAllUsers_limit(int userState, int num);
}