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

	// 获取所有待审核用户_限定数量
	List<User> getAllUsers_limit(int userState, int num);

	// 判断用户是否登录
	Boolean isLogin(String username, String password);

	// zyq_message_ajax_获得用户基本信息
	List<User> getUserInfo(String username);

	// 通过用户Id获取用户名
	String getUserNameById(String userId);

	// zzl_获取指定用户信息_2017年11月10日11:46:39
	List<User> getUserInfoById(String userId);
}