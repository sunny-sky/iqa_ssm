package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.vo.Permission_RoleView;

public interface RoleServece {
	// 获取所有角色
	List<Permission_RoleView> getAllRoles();
}
