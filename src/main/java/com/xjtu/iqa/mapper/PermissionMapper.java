package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Permission;
import com.xjtu.iqa.po.PermissionExample;

public interface PermissionMapper {
	int deleteByPrimaryKey(String PERMISSIONID);

	int insert(Permission record);

	int insertSelective(Permission record);

	List<Permission> selectByExample(PermissionExample example);

	Permission selectByPrimaryKey(String PERMISSIONID);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);

	// 获取所有权限
	List<Permission> getAllPermission();

	// 删除权限
	void deletePermission(String permissionId);

	// 获取角色还未得到的权限
	List<Permission> notObtainRolePermission(String roleId);

	// 获取角色已得到的权限
	List<Permission> obtainRolePermission(String roleId);

	// 根据物理名查看权限ID
	String getPermissionIdByPhysicalName(String physicalName);

	// 根据物理名查看权限ID
	String getPermissionIdByPhysicalName2(String physicalName, String permissionId);

	// 根据逻辑名查看权限ID
	String getPermissionIdByLogicName(String logicName);

	String getPermissionIdByLogicName2(String logicName, String permissionId);
}