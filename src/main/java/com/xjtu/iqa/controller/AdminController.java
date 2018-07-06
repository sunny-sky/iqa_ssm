package com.xjtu.iqa.controller;



import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjtu.iqa.service.CommunityQuestionService;
import com.xjtu.iqa.service.FaqQuestionService;
import com.xjtu.iqa.service.RobotAnswerService;
import com.xjtu.iqa.service.UserService;

@Controller
@RequestMapping("")
public class AdminController {
	@Autowired
	CommunityQuestionService communityQuestionService;
	@Autowired
	FaqQuestionService faqQuestionService;
	@Autowired
	UserService userService;
	@Autowired
	RobotAnswerService robotAnswerService;
	
	Logger logger = Logger.getLogger(AdminController.class);
	
	@RequestMapping("adminHomePage")
    public String adminHomePage(HttpSession session) {		
		//待处理事件,faqquestion表中FAQSTATE字段为1
		int eventUnresolvedCounts = robotAnswerService.Unresolved().size();
		//待处理问题，社区问题表
		int problemUnresolvedCounts = communityQuestionService.problemUnresolved().size();
		//待审核FAQ
		int faqPendingCounts = faqQuestionService.faqPendingAudits().size();
		//待审核用户
		int userPendingCounts = userService.userPendingAudits().size();
		
		session.setAttribute("eventUnresolvedCounts", eventUnresolvedCounts);
		session.setAttribute("problemUnresolvedCounts", problemUnresolvedCounts);
		session.setAttribute("faqPendingCounts", faqPendingCounts);
		session.setAttribute("userPendingCounts", userPendingCounts);
		
		logger.info("4个待审核参数为：一："+eventUnresolvedCounts+"二："+problemUnresolvedCounts+"三："+faqPendingCounts+"四："+userPendingCounts);
		
        return "admin/adminHomePage";
    }
}
