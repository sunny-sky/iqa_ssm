package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.po.Equipments;

public interface EquipmentsService {

	//获取所有用户设备信息 -- tbl_equipments表
	List<Equipments> getAllEquipments() ;
	
	//获取要编辑的用户设备信息
	Equipments getEquipmentInfo(String user, String department);
	
	//更改用户设备信息
	void updateEquipment(String equipmentId, String brand, String cfg_time, String department, String user,
			String cPU, String rAM, String rOM, String os, String browser, String office_software, String used_for,
			String iP, String mAC, String region);
	
	//添加用户设备
	void addUserEquipment(String brand, String configure_time, String department, String user, String cPU,
			String rAM, String rOM, String os, String browser, String office_software, String used_for, String iP,
			String mAC, String region);
}
