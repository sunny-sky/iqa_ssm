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
import com.xjtu.iqa.mapper.CommunityQuestionMapper;
import com.xjtu.iqa.service.ProblemManagerService;
import com.xjtu.iqa.util.JsonUtil;
import com.xjtu.iqa.vo.ProblemView;
import com.xjtu.iqa.vo.Problem_AnswerView;

@Controller
public class ProblemManagerController {
	@Autowired
	ProblemManagerService problemManagerService;
	@Autowired
	CommunityQuestionMapper communityQuestionMapper;
	
	Logger logger = Logger.getLogger(ProblemManagerController.class);
	
	
	
	@RequestMapping(value="problemPage",method=RequestMethod.GET)
	public ModelAndView problemPage()
	{
		ModelAndView mv = new ModelAndView("admin/problemPage");
		
		//!!!	分页
		//isanswer:0--没有最佳答案；1--有最佳答案			questionstate：0--待处理
		//获取问题中心没有最佳答案的问题(int isanswer,int questionState,int startnum,int count)
		List<ProblemView> problemUnresolved = problemManagerService.problemUnresolved(0,0);
						
		//获取待处理问题总数(int isanswer,int questionState)
		int unResolvedCounts = communityQuestionMapper.problemCount(0,0);
		
		//获取问题中心有最佳答案的问题(int isanswer,int questionState,int startnum,int count)
		List<Problem_AnswerView> problemResolved  = problemManagerService.problemResolved(1,0);
						
		//获取已处理问题总数(int isanswer,int questionState)
		int resolvedCounts = communityQuestionMapper.problemCount(1,0);
		mv.addObject("problemUnresolved",problemUnresolved);
		mv.addObject("unResolvedCounts", unResolvedCounts);
		
		mv.addObject("problemResolved",problemResolved);
		mv.addObject("resolvedCounts", resolvedCounts);	
		logger.info(unResolvedCounts);
		logger.info(resolvedCounts);
				
		return mv;		
	}
	
	/**
	 * 更新社区问题状态
	 */
	@ResponseBody
	@RequestMapping(value="/ignoreQuestion",method=RequestMethod.POST)
	public String ignoreQuestion(HttpServletRequest request,HttpSession session){
		String username = (String) session.getAttribute("UserName");
		JSONObject jsonObject = new JSONObject();
		if (username==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 			
			return result;
		}else{
			String questionId = request.getParameter("questionId");
			
			//更新tbl_communityquestion表问题状态 -- 2是忽略
			problemManagerService.updateCommunityQuestionState(questionId,2);
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		}

	}
	
	//已处理问题
	/*@ResponseBody
	@RequestMapping(value={"/getResolvedProblem"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="application/json;charset=UTF-8")
	public String getResolvedProblem(HttpServletRequest request,HttpSession session){			
		String username = (String) session.getAttribute("UserName");
		JSONObject jsonObject = new JSONObject();
		if (username==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 			
			return result;
		}else{
			//获取问题中心有最佳答案的问题	
			List<Problem_AnswerView> problemResolved = ProblemManagerService.problemResolved();
			jsonObject.put("problemResolved", problemResolved);
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		}
	}*/
	
	//待处理问题
/*	@ResponseBody
	@RequestMapping(value={"/getUnResolvedProblem"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="application/json;charset=UTF-8")
	public String getUnResolvedProblem(HttpServletRequest request,HttpSession session){			
		String username = (String) session.getAttribute("UserName");
		JSONObject jsonObject = new JSONObject();
		if (username==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 			
			return result;
		}else{
			//获取待处理问题
			List<ProblemView> problemUnresolved = ProblemManagerService.problemUnresolved();
			jsonObject.put("problemUnresolved", problemUnresolved);
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		}
	}*/
	
	/**
	 * @abstract 获取未处理问题详情
	 */
	@RequestMapping(value="showUnResolvedProblem",method=RequestMethod.GET)
	public ModelAndView showUnResolvedProblem(String p){
		ModelAndView mv = new ModelAndView("admin/showUnResolvedProblem");
		
		//获取未处理问题详情
		ProblemView unResolvedProblemDetail = problemManagerService.getUnResolvedEventDetail(p);
		
		mv.addObject("unResolvedProblemDetail", unResolvedProblemDetail);
		return mv;
	}
	
	/**
	 * @abstract 获取已处理问题详情
	 */
	@RequestMapping(value="showResolvedProblem",method=RequestMethod.GET)
    public ModelAndView  showResolvedProblem(String p){
		ModelAndView mv = new ModelAndView("admin/showResolvedProblem");

		//获取已处理问题详情
		Problem_AnswerView resolvedProblemDetail = problemManagerService.getResolvedEventDetail(p);
		
		mv.addObject("resolvedProblemDetail", resolvedProblemDetail);
		return mv;
    }
}
