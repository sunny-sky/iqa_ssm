package com.xjtu.iqa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xjtu.iqa.service.EventManagerService;
import com.xjtu.iqa.service.FaqManagerService;
import com.xjtu.iqa.service.HomeService;
import com.xjtu.iqa.service.ProblemManagerService;
import com.xjtu.iqa.service.UserService;
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
}
