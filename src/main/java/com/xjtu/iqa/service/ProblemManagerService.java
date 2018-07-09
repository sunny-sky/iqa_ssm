package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.vo.ProblemView;
import com.xjtu.iqa.vo.Problem_AnswerView;

public interface ProblemManagerService {
	/**
	 * 获取问题中心没有最佳答案的问题
	 */
	List<ProblemView> problemUnresolved(int isanswer,int questionState);
	
	/**
	 * @abstract 获取问题中心有最佳答案的问题
	 * @return problemResolveds
	 */
	List<Problem_AnswerView> problemResolved(int isanswer, int questionState);
	
	/**
	 * 忽略问题
	 */
	void updateCommunityQuestionState(String questionId, int questionState); 
	

	/**
	 * 获取已处理问题具体信息
	 */
	Problem_AnswerView getResolvedEventDetail(String communityProblemId);
	
	/**
	 * 获取未处理问题详情
	 */
	ProblemView getUnResolvedEventDetail(String communityProblemId);
}
