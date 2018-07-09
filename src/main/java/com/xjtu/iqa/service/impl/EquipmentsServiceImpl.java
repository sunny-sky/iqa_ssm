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
}
