package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.vo.UserView;

public interface UserService {
	
	List<UserView> getAllPendingAuditUsers(int userstate);
}
