package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.vo.HomePageView;

public interface HomeService {
	//任务列表
	List<HomePageView> todoList();
	
	//获取地区名及各地区设备数量
	List<HomePageView> regionCount();
	
	//获取待处理事件/问题数
	List<HomePageView> eventAndProblem();
	
	//获取一级分类名及各分类数量
	List<HomePageView> classifyCount();
}
