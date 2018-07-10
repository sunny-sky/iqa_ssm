package com.xjtu.iqa.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.po.User;
import com.xjtu.iqa.service.UserService;
import com.xjtu.iqa.util.MD5;
import com.xjtu.iqa.vo.UserView;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	@Override
	public List<UserView> getAllPendingAuditUsers(int userstate) {
		// 待审核视图
		List<UserView> pendingAuditUsers = new ArrayList<UserView>();

		// 获取所有待审核用户 -- 即USERSTATE = 1
		List<User> userLists = userMapper.getAllUsers(userstate);

		for (User userList : userLists)

		{
			UserView pendingAuditUser = new UserView();
			pendingAuditUser.setUSERID(userList.getUSERID());
			pendingAuditUser.setUSERNAME(userList.getUSERNAME());
			pendingAuditUser.setUSEREMAIL(userList.getUSEREMAIL());
			pendingAuditUser.setGENDER(userList.getGENDER());
			pendingAuditUser.setUSERBIRTHDAY(userList.getUSERBIRTHDAY());
			pendingAuditUser.setUSERADDRESS(userList.getUSERADDRESS());
			pendingAuditUser.setUSERSIGNATURE(userList.getUSERSIGNATURE());
			pendingAuditUser.setCREATETIME(userList.getCREATETIME());
			pendingAuditUser.setROLEID(userList.getROLEID());
			String roleName = userMapper.getRoleNameByUserId(userList.getUSERID());
			pendingAuditUser.setROLENAME(roleName);
			pendingAuditUser.setAVATAR(userList.getAVATAR());
			pendingAuditUsers.add(pendingAuditUser);
		}
		return pendingAuditUsers;
	}

	/**
	 * @abstract:获取所有普通用户信息
	 */
	@Override
	public List<UserView> getAllUsers(int userstate, String rolename) {
		// 普通用户视图
		List<UserView> ordinaryUsers = new ArrayList<UserView>();
		// 获取所有普通用户信息 -- 即USERSTATE = 2 且 角色名是普通用户
		List<User> userLists = userMapper.getUserLists(userstate, rolename);
		for (User userList : userLists) {
			UserView ordinaryUser = new UserView();
			ordinaryUser.setUSERID(userList.getUSERID());
			ordinaryUser.setUSERNAME(userList.getUSERNAME());
			ordinaryUser.setUSEREMAIL(userList.getUSEREMAIL());
			ordinaryUser.setGENDER(userList.getGENDER());
			ordinaryUser.setUSERBIRTHDAY(userList.getUSERBIRTHDAY());
			ordinaryUser.setUSERADDRESS(userList.getUSERADDRESS());
			ordinaryUser.setUSERSIGNATURE(userList.getUSERSIGNATURE());
			ordinaryUser.setCREATETIME(userList.getCREATETIME());

			ordinaryUser.setROLEID(userList.getROLEID());
			String roleName = userMapper.getRoleNameByUserId(userList.getUSERID());
			ordinaryUser.setROLENAME(roleName);

			ordinaryUser.setAVATAR(userList.getAVATAR());
			ordinaryUsers.add(ordinaryUser);
		}
		return ordinaryUsers;
	}

	/**
	 * @abstract:用户通过审核/加入黑名单
	 */
	@Override
	public void updateUserState(String userId, int userState) {

		userMapper.updateUserState(userId, userState);

	}

	/**
	 * @abstract:获取指定用户信息
	 */
	@Override
	public UserView getUserInfoById(String userId) {
		UserView userView = new UserView();

		// 获取用户信息
		List<User> userList = userMapper.getUserInfoById(userId);

		userView.setUSERID(userList.get(0).getUSERID());
		userView.setUSERNAME(userList.get(0).getUSERNAME());
		userView.setUSEREMAIL(userList.get(0).getUSEREMAIL());
		userView.setGENDER(userList.get(0).getGENDER());
		userView.setUSERBIRTHDAY(userList.get(0).getUSERBIRTHDAY());
		userView.setUSERADDRESS(userList.get(0).getUSERADDRESS());
		userView.setUSERSIGNATURE(userList.get(0).getUSERSIGNATURE());
		userView.setCREATETIME(userList.get(0).getCREATETIME());

		userView.setROLEID(userList.get(0).getROLEID());
		String roleName = userMapper.getRoleNameByUserId(userList.get(0).getUSERID());
		userView.setROLENAME(roleName);

		userView.setAVATAR(userList.get(0).getAVATAR());

		return userView;
	}

	/**
	 * 重置密码
	 * 
	 * @param password
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	@Override
	public void resetPass(String userid, String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String pass = MD5.EncoderByMd5(password);
		System.out.println("重置密码：" + pass);
		userMapper.resetPass(userid, pass);
	}

	// 判断用户是否登录
	@Override
	public boolean isLogin(String username, String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		password = MD5.EncoderByMd5(password);
		// 判断用户是否登录
		Boolean loginUser = userMapper.isLogin(username, password);
		return loginUser;
	}
}
