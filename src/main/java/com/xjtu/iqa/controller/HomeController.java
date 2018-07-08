package com.xjtu.iqa.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.xjtu.iqa.service.EventManagerService;
import com.xjtu.iqa.service.FaqManagerService;
import com.xjtu.iqa.service.HomeService;
import com.xjtu.iqa.service.ProblemManagerService;
import com.xjtu.iqa.service.UserService;
import com.xjtu.iqa.util.JsonUtil;
import com.xjtu.iqa.vo.EventView;
import com.xjtu.iqa.vo.FaqView;
import com.xjtu.iqa.vo.HomePageView;
import com.xjtu.iqa.vo.ProblemView;
import com.xjtu.iqa.vo.UserView;

@Controller
public class HomeController {
	@Autowired
	EventManagerService eventManagerService;
	@Autowired
	ProblemManagerService problemManagerService;
	@Autowired
	FaqManagerService faqManagerService;
	@Autowired
	UserService userService;
	@Autowired
	HomeService homeService;
	
	Logger logger = Logger.getLogger(HomeController.class);

	// 首页
	@RequestMapping(value = "homePage", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("admin/homePage");
		// 待处理事件
		List<EventView> eventUnresolved = eventManagerService.eventUnresolved(0, 0);

		// 待处理问题
		List<ProblemView> problemUnresolved = problemManagerService.problemUnresolved(0, 0);

		// 待审核FAQ
		List<FaqView> faqPendingAudit = faqManagerService.faqPendingAudits(1);

		// 待审核用户
		List<UserView> pendingAuditUsers = userService.getAllPendingAuditUsers(1);

		List<HomePageView> lists = homeService.todoList();

		mv.addObject("eventUnresolvedCounts", eventUnresolved.size());
		mv.addObject("problemUnresolvedCounts", problemUnresolved.size());
		mv.addObject("pendCounts", faqPendingAudit.size());
		mv.addObject("pendingAuditCounts", pendingAuditUsers.size());
		mv.addObject("lists", lists);
		return mv;
	}

	// 获取地区名及各地区设备数量
	@ResponseBody
	@RequestMapping(value = { "regionCount" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public String regionCount(HttpServletRequest request, HttpSession session) {
		String username = (String) session.getAttribute("UserName");
		JSONObject jsonObject = new JSONObject();

//		if (username == null) {
//			jsonObject.put("value", "0");
//			String result = JsonUtil.toJsonString(jsonObject);
//			logger.info("获取地区名及各地区设备数量"+result);
//			return result;
//		} else {
			//
			List<HomePageView> list = homeService.regionCount();
			jsonObject.put("regionList", list);
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			logger.info("获取地区名及各地区设备数量"+result);
			return result;
//		}
	}
	
	/*
	 * 获取一级分类名及各分类数量
	 */
	@ResponseBody
	@RequestMapping(value={"classifyCount"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="application/json;charset=UTF-8")
	public String firstClassifyCount(HttpServletRequest request,HttpSession session){				
		String username = (String) session.getAttribute("UserName");
		JSONObject jsonObject = new JSONObject();
		
//		if (username==null) {
//			jsonObject.put("value", "0");
//			String result = JsonUtil.toJsonString(jsonObject); 
//			logger.info("获取一级分类名及各分类数量"+result);
//			return result;
//		}else{
			//
		 	List<HomePageView> list = homeService.classifyCount();
			jsonObject.put("classifyList", list);
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject); 
			logger.info("获取一级分类名及各分类数量"+result);
			return result;
//		}
	}
	
	@ResponseBody
	@RequestMapping(value={"eventAndProblem"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="application/json;charset=UTF-8")
	public String eventAndProblem(HttpServletRequest request,HttpSession session){
				
		String username = (String) session.getAttribute("UserName");
		JSONObject jsonObject = new JSONObject();
		
//		if (username==null) {
//			jsonObject.put("value", "0");
//			String result = JsonUtil.toJsonString(jsonObject); 
//			logger.info("eventAndProblem"+result);
//			return result;
//		}else{
			//
		 	List<HomePageView> list = homeService.eventAndProblem();
			jsonObject.put("time", list);
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject); 		
			logger.info("eventAndProblem"+result);
			return result;
//		}
	}
}
