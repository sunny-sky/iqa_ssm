package com.xjtu.iqa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.RoleMapper;
import com.xjtu.iqa.po.Role;
import com.xjtu.iqa.service.RoleServece;
import com.xjtu.iqa.vo.Permission_RoleView;

@Service
public class RoleServeceImpl implements RoleServece {
	@Autowired
	RoleMapper roleMapper;

	// 获取所有角色
	@Override
	public List<Permission_RoleView> getAllRoles() {
		List<Permission_RoleView> roleViews = new ArrayList<Permission_RoleView>();

		List<Role> rolePersistences = roleMapper.getAllRoles();

		for (Role rolePersistence : rolePersistences) {
			Permission_RoleView roleView = new Permission_RoleView();
			roleView.setROLEID(rolePersistence.getROLEID());
			roleView.setROLENAME(rolePersistence.getROLENAME());
			roleViews.add(roleView);
		}
		return roleViews;
	}
}
