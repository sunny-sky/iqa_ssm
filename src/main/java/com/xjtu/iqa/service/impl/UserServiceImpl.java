package com.xjtu.iqa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.po.User;
import com.xjtu.iqa.service.UserService;
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
}
