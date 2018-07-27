package com.xjtu.iqa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.xjtu.iqa.mapper.FaqClassifyMapper;
import com.xjtu.iqa.mapper.UserQuestionMapper;
import com.xjtu.iqa.po.FaqClassify;
import com.xjtu.iqa.service.EventManagerService;
import com.xjtu.iqa.util.JsonUtil;
import com.xjtu.iqa.vo.EventView;
import com.xjtu.iqa.vo.Event_AnswerView;

@Controller
public class EventManagerController {
	@Autowired
	EventManagerService eventManagerService;
	@Autowired
	UserQuestionMapper userQuestionMapper;
	@Autowired
	FaqClassifyMapper faqClassifyMapper;

	// @abstract:事件管理_eventPage
	@RequestMapping(value = "eventPage")
	public ModelAndView eventPage(HttpServletRequest req, HttpServletResponse respon) {
		ModelAndView mv = new ModelAndView("admin/eventPage");

		// 待处理事件_只显示满意度表中满意度为0的记录
		List<EventView> eventUnresolved = eventManagerService.eventUnresolved(0, 0);

		// 已处理事件_只显示满意度表中满意度为1的记录
		List<EventView> eventResolved = eventManagerService.eventUnresolved(1, 0);

		// 获取已处理事件总数
		int eventResolvedCount = userQuestionMapper.getResolvedCount(1, 0);

		/*
		 * String strCurPage = req.getParameter("Cur_Page"); if(strCurPage ==
		 * null) strCurPage ="1"; int intCurPage = Integer.parseInt(strCurPage);
		 * //认为每页显示12条 int PageCount = 1;
		 * 
		 * PageBean<EventView> pageBean = new PageBean<EventView>();
		 * //（满意度，每页显示条数） pageBean =
		 * EventManagerService.FindEventViewPageBean(0,0,intCurPage,PageCount);
		 * // 把分页的列表提取出来 List<EventView> EntryList = pageBean.getEntryList();
		 */

		// mv.addObject("pageBean",pageBean);
		// mv.addObject("EntryList",EntryList);
		mv.addObject("eventUnresolved", eventUnresolved);
		mv.addObject("UnresolvedCounts", eventUnresolved.size());
		mv.addObject("eventResolved", eventResolved);
		mv.addObject("ResolvedCounts", eventResolvedCount);

		return mv;
	}

	
	// @abstract:事件已处理_查看事件详情_showResolvedEvent
	@RequestMapping(value = "showResolvedEvent", method = RequestMethod.GET)
	public ModelAndView showResolvedEvent(String q) {
		ModelAndView modelAndView = new ModelAndView("admin/showResolvedEvent");

		// 获取已处理事件详情
		Event_AnswerView resolvedEventDetail = eventManagerService.getResolvedEventDetail(q);
		// 获取一级分类名
		List<FaqClassify> classifyPersistences = faqClassifyMapper.FirstClassify_robot();
		if (classifyPersistences == null || classifyPersistences.size() == 0) {
			return null;
		}
		modelAndView.addObject("resolvedEventDetail", resolvedEventDetail);
		modelAndView.addObject("FirstLevel", classifyPersistences);
		return modelAndView;
	}

	/**
	 * @abstract:事件待处理_查看事件详情_showUnResolvedEvent.ftl
	 */
	@RequestMapping(value = "showUnResolvedEvent", method = RequestMethod.GET)
	public ModelAndView showUnResolvedEvent(String q) {
		ModelAndView modelAndView = new ModelAndView("admin/showUnResolvedEvent");

		// 获取待处理事件详情
		EventView unResolvedEventDetail = eventManagerService.getUnResolvedEventDetail(q);

		modelAndView.addObject("UnResolvedEventDetail", unResolvedEventDetail);
		return modelAndView;
	}
	
	/**
	 * 忽略用户提问
	 */
	@ResponseBody
	@RequestMapping(value="ignoreUserQuestion",method=RequestMethod.POST)
	public String ignoreUserQuestion(HttpServletRequest request,HttpSession session){	
		String username = (String) session.getAttribute("username");
		JSONObject jsonObject = new JSONObject();
		if (username==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 			
			return result;
		}else{
			String userQuestionId = request.getParameter("userQuestionId");	
			//更新tbl_robotanswer表用户问题状态 -- 2是忽略
			eventManagerService.updateQuestionState(userQuestionId,2);
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		}
	}
}
