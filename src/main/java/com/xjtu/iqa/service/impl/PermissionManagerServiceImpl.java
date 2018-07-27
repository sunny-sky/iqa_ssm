package com.xjtu.iqa.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.PermissionMapper;
import com.xjtu.iqa.mapper.RolePermissionMapper;
import com.xjtu.iqa.po.Permission;
import com.xjtu.iqa.po.RolePermission;
import com.xjtu.iqa.service.PermissionManagerService;
import com.xjtu.iqa.vo.PermissionView;
import com.xjtu.iqa.vo.Permission_RoleView;

@Service
public class PermissionManagerServiceImpl implements PermissionManagerService {
	@Autowired
	PermissionMapper permissionMapper;
	@Autowired
	RolePermissionMapper rolePermissionMapper;

	// 获取所有权限列表
	@Override
	public List<PermissionView> getPermissionList() {
		// 所有权限视图
		List<PermissionView> permissionViews = new ArrayList<PermissionView>();

		// 获取所有权限
		List<Permission> permissionPersistences = permissionMapper.getAllPermission();

		for (Permission permissionPersistence : permissionPersistences) {
			// 新建单个权限视图
			PermissionView permissionView = new PermissionView();
			permissionView.setPermissionId(permissionPersistence.getPERMISSIONID());
			permissionView.setPermissionPhysicalName(permissionPersistence.getPERMISSIONPHYSICALNAME());
			permissionView.setPermissionLogicName(permissionPersistence.getPERMISSIONLOGICNAME());
			permissionView.setTime(permissionPersistence.getTIME());
			permissionViews.add(permissionView);
		}
		return permissionViews;
	}

	// 获取角色还未得到的权限
	@Override
	public List<Permission_RoleView> notObtainRolePermission(String roleId) {
		List<Permission_RoleView> permission_RoleViews = new ArrayList<Permission_RoleView>();

		List<Permission> lists = permissionMapper.notObtainRolePermission(roleId);

		System.out.println("未获得权限条数：" + lists.size());

		for (Permission list : lists) {
			Permission_RoleView permission_RoleView = new Permission_RoleView();

			permission_RoleView.setPERMISSIONID(list.getPERMISSIONID());
			permission_RoleView.setPERMISSIONPHYSICALNAME(list.getPERMISSIONPHYSICALNAME());
			permission_RoleView.setPERMISSIONLOGICNAME(list.getPERMISSIONLOGICNAME());

			permission_RoleViews.add(permission_RoleView);
		}

		return permission_RoleViews;

	}

	// 获取角色已得到的权限
	@Override
	public List<Permission_RoleView> obtainRolePermission(String roleId) {
		List<Permission_RoleView> permission_RoleViews = new ArrayList<Permission_RoleView>();

		List<Permission> lists = permissionMapper.obtainRolePermission(roleId);
		System.out.println("已获得权限条数：" + lists.size());
		for (Permission list : lists) {
			Permission_RoleView permission_RoleView = new Permission_RoleView();

			permission_RoleView.setPERMISSIONID(list.getPERMISSIONID());
			permission_RoleView.setPERMISSIONPHYSICALNAME(list.getPERMISSIONPHYSICALNAME());
			permission_RoleView.setPERMISSIONLOGICNAME(list.getPERMISSIONLOGICNAME());

			permission_RoleViews.add(permission_RoleView);
		}
		return permission_RoleViews;
	}

	// 将选中权限插入到角色-权限表中 -- 逐条插入
	@Override
	public void addPermissionToRole(String roleId, String permissionId) {

		// 判断用户权限表中是否已存在此权限
		List<RolePermission> list = rolePermissionMapper.isExist(roleId, permissionId);
		if (list.size() == 0) {
			// 为角色增加权限
			rolePermissionMapper.addPermissionToRole(UUID.randomUUID().toString(), roleId, permissionId);
		}
	}

	// 将选中权限从角色-权限表中移除
	@Override
	public void deletePermissionToRole(String roleId, String permissionId) {
		// 判断用户权限表中是否已存在此权限
		List<RolePermission> list = rolePermissionMapper.isExist(roleId, permissionId);
		if (list.size() > 0) {
			// 移除角色已获取的权限
			rolePermissionMapper.deletePermissionToRole(roleId, permissionId);
		}
	}
	
	//增加权限
	public void addPermission(String logicName, String physicalName) {
		Permission permissionPersistence = new Permission();
		permissionPersistence.setPERMISSIONID(UUID.randomUUID().toString());
		permissionPersistence.setPERMISSIONPHYSICALNAME(physicalName);
		permissionPersistence.setPERMISSIONLOGICNAME(logicName);
		
		Date date=new Date();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time = format.format(date);
		permissionPersistence.setTIME(time);
    	permissionMapper.insert(permissionPersistence);
	}
	
	//更改权限
	public void updatePermission(String permissionId, String physicalName, String logicName) {
		Permission permissionPersistence = new Permission();
		permissionPersistence.setPERMISSIONID(permissionId);
		permissionPersistence.setPERMISSIONPHYSICALNAME(physicalName);
		permissionPersistence.setPERMISSIONLOGICNAME(logicName);		
		Date date=new Date();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time = format.format(date);   
    	permissionPersistence.setTIME(time);
    	permissionMapper.updateByPrimaryKey(permissionPersistence);
	}
	
	//删除权限
	public void deletePermission(String permissionId) {
		
		permissionMapper.deletePermission(permissionId);
		
	}

}
