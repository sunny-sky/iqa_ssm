package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.vo.ProblemView;

public interface ProblemManagerService {
	/**
	 * 获取问题中心没有最佳答案的问题
	 */
	List<ProblemView> problemUnresolved(int isanswer,int questionState);
}
