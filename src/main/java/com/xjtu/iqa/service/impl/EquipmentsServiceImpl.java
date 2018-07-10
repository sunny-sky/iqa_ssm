package com.xjtu.iqa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.EquipmentsMapper;
import com.xjtu.iqa.po.Equipments;
import com.xjtu.iqa.service.EquipmentsService;

@Service
public class EquipmentsServiceImpl implements EquipmentsService {
	@Autowired
	EquipmentsMapper equipmentsMapper;

	// 获取所有用户设备信息 -- tbl_equipments表
	@Override
	public List<Equipments> getAllEquipments() {
		List<Equipments> Equipmentss = new ArrayList<Equipments>();

		List<Equipments> equipmentsLists = equipmentsMapper.getAllEquipments();

		for (Equipments equipmentsList : equipmentsLists) {
			Equipments Equipments = new Equipments();

			Equipments.setEQUIPMENT_ID(equipmentsList.getEQUIPMENT_ID());
			Equipments.setUSER(equipmentsList.getUSER());
			Equipments.setDEPARTMENT(equipmentsList.getDEPARTMENT());
			Equipments.setBRAND(equipmentsList.getBRAND());
			Equipments.setCONFIGURE_TIME(equipmentsList.getCONFIGURE_TIME());
			Equipments.setCPU(equipmentsList.getCPU());
			Equipments.setRAM(equipmentsList.getRAM());
			Equipments.setROM(equipmentsList.getROM());
			Equipments.setOS(equipmentsList.getOS());
			Equipments.setBROWSER(equipmentsList.getBROWSER());
			Equipments.setOFFICE_SOFTWARE(equipmentsList.getOFFICE_SOFTWARE());
			Equipments.setUSED_FOR(equipmentsList.getUSED_FOR());
			Equipments.setIP_ADDRESS(equipmentsList.getIP_ADDRESS());
			Equipments.setMAC_ADDRESS(equipmentsList.getMAC_ADDRESS());
			Equipments.setREGION(equipmentsList.getREGION());

			Equipmentss.add(Equipments);
		}
		return Equipmentss;
	}

	// 获取要编辑的用户设备信息
	@Override
	public Equipments getEquipmentInfo(String user, String department) {
		Equipments Equipments = new Equipments();

		// 根据用户名和部门名获取信息
		List<Equipments> equipmentsList = equipmentsMapper.getEquipmentsInfo(user, department);

		Equipments.setEQUIPMENT_ID(equipmentsList.get(0).getEQUIPMENT_ID());
		Equipments.setUSER(equipmentsList.get(0).getUSER());
		Equipments.setDEPARTMENT(equipmentsList.get(0).getDEPARTMENT());
		Equipments.setBRAND(equipmentsList.get(0).getBRAND());
		Equipments.setCONFIGURE_TIME(equipmentsList.get(0).getCONFIGURE_TIME());
		Equipments.setCPU(equipmentsList.get(0).getCPU());
		Equipments.setRAM(equipmentsList.get(0).getRAM());
		Equipments.setROM(equipmentsList.get(0).getROM());
		Equipments.setOS(equipmentsList.get(0).getOS());
		Equipments.setBROWSER(equipmentsList.get(0).getBROWSER());
		Equipments.setOFFICE_SOFTWARE(equipmentsList.get(0).getOFFICE_SOFTWARE());
		Equipments.setUSED_FOR(equipmentsList.get(0).getUSED_FOR());
		Equipments.setIP_ADDRESS(equipmentsList.get(0).getIP_ADDRESS());
		Equipments.setMAC_ADDRESS(equipmentsList.get(0).getMAC_ADDRESS());
		Equipments.setREGION(equipmentsList.get(0).getREGION());

		return Equipments;
	}

	// 更改用户设备信息
	@Override
	public void updateEquipment(String equipmentId, String brand, String cfg_time, String department, String user,
			String cPU, String rAM, String rOM, String os, String browser, String office_software, String used_for,
			String iP, String mAC, String region) {
		// TODO Auto-generated method stub
		equipmentsMapper.updateEquipment(equipmentId, brand, cfg_time, department, user, cPU, rAM, rOM, os, browser,
				office_software, used_for, iP, mAC, region);
	}

	// 添加用户设备
	public void addUserEquipment(String brand, String configure_time, String department, String user, String cPU,
			String rAM, String rOM, String os, String browser, String office_software, String used_for, String iP,
			String mAC, String region) {
		equipmentsMapper.addUserEquipment(brand, configure_time, department, user, cPU, rAM, rOM, os, browser,
				office_software, used_for, iP, mAC, region);

	}
}
