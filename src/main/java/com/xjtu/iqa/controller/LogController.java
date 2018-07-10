package com.xjtu.iqa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xjtu.iqa.service.LogService;
import com.xjtu.iqa.vo.logindexView;

@Controller
public class LogController {
	@Autowired
	LogService logService;

	// zpz_Log_查看Log
	@RequestMapping(value = "logIndex", method = RequestMethod.GET)
	public ModelAndView advise() { // !!! 分页
		ModelAndView mv = new ModelAndView("admin/logIndex");
		List<logindexView> logindexViews = logService.logindexViews(0, 100);
		mv.addObject("log_list", logindexViews);
		return mv;
	}
}
