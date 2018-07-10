package com.xjtu.iqa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.xjtu.iqa.mapper.FaqClassifyMapper;
import com.xjtu.iqa.mapper.FaqPictureMapper;
import com.xjtu.iqa.mapper.FaqQuestionMapper;
import com.xjtu.iqa.po.FaqClassify;
import com.xjtu.iqa.po.FaqPicture;
import com.xjtu.iqa.service.FaqManagerService;
import com.xjtu.iqa.util.JsonUtil;
import com.xjtu.iqa.vo.FaqView;
import com.xjtu.iqa.vo.PageBean;

@Controller
public class FaqManagerController {
	@Autowired
	FaqManagerService faqManagerService;
	@Autowired
	FaqQuestionMapper faqQuestionMapper;
	@Autowired
	FaqClassifyMapper faqClassifyMapper;
	@Autowired
	FaqPictureMapper faqPictureMapper;

	Logger logger = Logger.getLogger(FaqManagerController.class);

	@RequestMapping(value = "faqPage", method = RequestMethod.GET)
	public ModelAndView faqPage(HttpSession session, HttpServletRequest request, HttpServletResponse respon) {
		ModelAndView mv = new ModelAndView("admin/faqPage");

		// !!! 分页
		// FAQSTATE = 2 通过审核；FAQSTATE = 1待审核
		// 获取待审核FAQ
		List<FaqView> faqPendingAudit = faqManagerService.faqPendingAudits(1);
		// 获取待审核FAQ总数
		int pendCount = faqQuestionMapper.getCount(1);

		// 获取所有faq分类
		List<FaqClassify> classifyList = faqClassifyMapper.FirstClassify_robot();

		// 获取第一个分类已审核FAQ
		// List<FaqView> faqAudited =
		// FaqManagerService.faqAudited(classifyList.get(0).getFAQCLASSIFYID());

		String strCurPage = request.getParameter("Cur_Page");
		String classifyId = request.getParameter("classifyId");

		if (classifyId == null)
			classifyId = classifyList.get(0).getFAQCLASSIFYID();
		System.out.println("controller:" + classifyId);
		if (strCurPage == null)
			strCurPage = "1";
		int intCurPage = Integer.parseInt(strCurPage);
		// 认为每页显示12条
		int PageCount = 10;

		PageBean<FaqView> pageBean = new PageBean<FaqView>();
		// （满意度，每页显示条数）
		pageBean = faqManagerService.faqAudited(classifyId, 2, intCurPage, PageCount);

		// 把分页的列表提取出来
		List<FaqView> EntryList = pageBean.getEntryList();

		mv.addObject("faqPendingAudit", faqPendingAudit);
		mv.addObject("pageBean", pageBean);
		mv.addObject("EntryList", EntryList);
		mv.addObject("pendCount", pendCount);
		mv.addObject("faqAudited", EntryList);
		mv.addObject("classifyList", classifyList);
		mv.addObject("classifyId", classifyId);

		logger.info(pageBean);

		return mv;
	}

	// faq推荐栏
	@RequestMapping(value = "faqCommendPage", method = RequestMethod.GET)
	public ModelAndView faqCommendPage(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("admin/faqCommendPage");

		List<FaqPicture> faqPicList = faqManagerService.faqPicList(1, 10);

		mv.addObject("faqPicList", faqPicList);

		return mv;
	}
	
	// faq删除图片
	@ResponseBody
	@RequestMapping(value={"deletePic"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="text/plain;charset=UTF-8")
	public String deletePic(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//获取登录的管理员信息
		String username = (String) session.getAttribute("username");		
		
		if (username==null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("value", "0");
			return JsonUtil.toJsonString(jsonObject);			
		}else {			
			String faqPicId = request.getParameter("faqPicId");
			
			faqPictureMapper.deletePic(faqPicId,0);
			
			JSONObject jsonObject = new JSONObject();

			//删除成功返回1
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;				

		}
	}
	
	@ResponseBody
	@RequestMapping(value={"updateTitle"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="text/plain;charset=UTF-8")
	public String updateTitle(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//获取登录的管理员信息
		String username = (String) session.getAttribute("username");		
		
		if (username==null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("value", "0");
			return JsonUtil.toJsonString(jsonObject);			
		}else {			
			String faqPicId = request.getParameter("faqPicId");
			String picTitle = request.getParameter("picTitle");
			
			faqPictureMapper.updateTitle(faqPicId,picTitle);
			
			JSONObject jsonObject = new JSONObject();

			//保存知识成功返回1
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;				

		}
	}
}
