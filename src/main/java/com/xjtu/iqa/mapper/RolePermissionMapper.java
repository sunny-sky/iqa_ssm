package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Permission;
import com.xjtu.iqa.po.RolePermission;
import com.xjtu.iqa.po.RolePermissionExample;

public interface RolePermissionMapper {
	int deleteByPrimaryKey(String ROLEPERMISSIONID);

	int insert(RolePermission record);

	int insertSelective(RolePermission record);

	List<RolePermission> selectByExample(RolePermissionExample example);

	RolePermission selectByPrimaryKey(String ROLEPERMISSIONID);

	int updateByPrimaryKeySelective(RolePermission record);

	int updateByPrimaryKey(RolePermission record);

	// 判断用户权限表中是否已存在此权限
	List<RolePermission> isExist(String roleId, String permissionId);

	// 为角色增加权限
	void addPermissionToRole(String rolePermissionId, String roleId, String permissionId);

	// 移除角色已获取的权限
	void deletePermissionToRole(String roleId, String permissionId);

	// 多表联合查询获取到角色权限信息
	List<Permission> getRolePermissionByUId(String Uid);
}