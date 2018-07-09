package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.po.Equipments;

public interface EquipmentsService {

	//获取所有用户设备信息 -- tbl_equipments表
	List<Equipments> getAllEquipments() ;
}
