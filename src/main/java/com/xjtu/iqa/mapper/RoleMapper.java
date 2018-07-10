package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Role;
import com.xjtu.iqa.po.RoleExample;

public interface RoleMapper {
	int deleteByPrimaryKey(String ROLEID);

	int insert(Role record);

	int insertSelective(Role record);

	List<Role> selectByExample(RoleExample example);

	Role selectByPrimaryKey(String ROLEID);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	// 获取所有角色信息
	List<Role> getAllRoles();

	// 获取该员工本身角色外的其他角色 ！！！
	List<Role> getUnGotRoleList(String userId);

	// 查询当前用户角色 ！！！
	List<Role> getRoleInfoByUserId(String userId);
}