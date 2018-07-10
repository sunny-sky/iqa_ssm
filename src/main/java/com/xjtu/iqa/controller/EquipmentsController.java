package com.xjtu.iqa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.xjtu.iqa.mapper.EquipmentsMapper;
import com.xjtu.iqa.po.Equipments;
import com.xjtu.iqa.service.EquipmentsService;
import com.xjtu.iqa.util.JsonUtil;

@Controller
public class EquipmentsController {
	@Autowired
	EquipmentsService equipmentsService;
	@Autowired
	EquipmentsMapper equipmentsMapper;

	@RequestMapping(value = "configureUploadPage", method = RequestMethod.GET)
	public ModelAndView configureUploadPage(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("admin/configureUploadPage");

		return mv;
	}

	// 显示用户设备信息
	@RequestMapping(value = "configureEquipmentPage", method = RequestMethod.GET)
	public ModelAndView configureEquipmentPage() {
		ModelAndView mv = new ModelAndView("admin/configureEquipmentPage");

		// 获取所有用户设备信息 -- tbl_equipments表
		List<Equipments> equipmentsList = equipmentsService.getAllEquipments();

		mv.addObject("equipmentsList", equipmentsList);
		mv.addObject("equipmentsSize", equipmentsList.size());

		return mv;
	}

	// 获取要编辑的用户设备信息
	@ResponseBody
	@RequestMapping(value = "editEquipmentsInfo", method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public String editEquipmentsInfo(HttpServletRequest request, HttpSession session) {
		// 获取ajax传来数据
		String user = request.getParameter("user");
		String department = request.getParameter("department");

		// 获取要编辑的用户设备信息
		Equipments list = equipmentsService.getEquipmentInfo(user, department);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("editEquipmentsInfo", list);
		String result = JsonUtil.toJsonString(jsonObject);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "updateEquipments", method = RequestMethod.POST)
	public String updateEquipments(HttpServletRequest request, HttpSession session) {
		// 获取AJAX数据
		String equipmentId = request.getParameter("equipmentId");
		String user = request.getParameter("user");
		String department = request.getParameter("department");
		String brand = request.getParameter("band");
		String cfg_time = request.getParameter("cfg_time");
		String CPU = request.getParameter("CPU");
		String RAM = request.getParameter("RAM");
		String ROM = request.getParameter("ROM");
		String os = request.getParameter("os");
		String browser = request.getParameter("browser");
		String office_software = request.getParameter("office_software");
		String used_for = request.getParameter("used_for");
		String IP = request.getParameter("IP");
		String MAC = request.getParameter("MAC");
		String region = request.getParameter("region");

		// 更改用户设备信息
		equipmentsService.updateEquipment(equipmentId, brand, cfg_time, department, user, CPU, RAM, ROM, os, browser,
				office_software, used_for, IP, MAC, region);
		return "1";

	}

	// 删除用户设备信息
	@ResponseBody
	@RequestMapping(value = "deleteEquipment", method = RequestMethod.POST)
	public String deleteEquipment(HttpServletRequest request, HttpSession session) {
		// 获取ajax传值
		String equipment_id = request.getParameter("equipment_id");
		String[] str = equipment_id.split("_");
		String equipmentId = str[1];

		if (equipmentId == null) {
			return "0";
		} else {
			// 删除用户设备信息
			equipmentsMapper.deleteEquipment(equipmentId);
			return "1";
		}
	}
	
	//增加用户设备
		@ResponseBody
		@RequestMapping(value="addUserEquipments",method=RequestMethod.POST)
		public String addUserEquipment(HttpServletRequest request,HttpSession session){
			//获取AJAX数据
			String user = request.getParameter("user");
			String department = request.getParameter("department");
			String brand = request.getParameter("brand");
			String configure_time = request.getParameter("hello");		//时间
			String CPU = request.getParameter("CPU");
			String RAM = request.getParameter("RAM");
			String ROM = request.getParameter("ROM");
			String os = request.getParameter("os");
			String browser = request.getParameter("browser");
			String office_software = request.getParameter("office_software");
			String used_for = request.getParameter("used_for");
			String IP = request.getParameter("IP");
			String MAC = request.getParameter("MAC");
			String region = request.getParameter("region");
			
			//通过用户名及部门查找tbl_equipments表中是否已存在该设备
			boolean isExist = equipmentsMapper.isExist(user,department);

			if (isExist == false) {
				//添加用户设备
				equipmentsService.addUserEquipment(brand,configure_time,department,user,CPU,RAM,ROM,os,browser,office_software,used_for,IP,MAC,region);
				return "1";
			}else {
				return "0";
			}	
		}
}
