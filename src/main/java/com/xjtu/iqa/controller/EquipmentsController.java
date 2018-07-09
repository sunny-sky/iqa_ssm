package com.xjtu.iqa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xjtu.iqa.po.Equipments;
import com.xjtu.iqa.service.EquipmentsService;

@Controller
public class EquipmentsController {
	@Autowired
	EquipmentsService equipmentsService;

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
}
