package com.xjtu.iqa.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.xjtu.iqa.vo.UserView;

public interface UserService {
	
	List<UserView> getAllPendingAuditUsers(int userstate);
	
	//@abstract:获取所有普通用户信息
	List<UserView> getAllUsers(int userstate,String rolename);
	

	//@abstract:用户通过审核/加入黑名单
	void updateUserState(String userId, int userState); 
	
	//获取指定用户信息
	UserView getUserInfoById(String userId);
	
	//重置密码
	void resetPass(String userid, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	
	//判断用户是否登录
	boolean isLogin(String username, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException;
}
