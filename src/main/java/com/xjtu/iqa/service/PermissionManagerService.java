package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.vo.PermissionView;
import com.xjtu.iqa.vo.Permission_RoleView;

public interface PermissionManagerService {

	// 获取所有权限列表
	List<PermissionView> getPermissionList();

	// 获取角色还未得到的权限
	List<Permission_RoleView> notObtainRolePermission(String roleId);

	// 获取角色已得到的权限
	List<Permission_RoleView> obtainRolePermission(String roleId);

	// 将选中权限插入到角色-权限表中 -- 逐条插入
	void addPermissionToRole(String roleId, String permissionId);

	// 将选中权限从角色-权限表中移除
	void deletePermissionToRole(String roleId, String permissionId);

	// 增加权限
	void addPermission(String logicName, String physicalName);

	// 更改权限
	void updatePermission(String permissionId, String physicalName, String logicName);
	
	// 删除权限
	void deletePermission(String permissionId);

		
}
