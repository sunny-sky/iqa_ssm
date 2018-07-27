package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.vo.EventView;
import com.xjtu.iqa.vo.Event_AnswerView;

public interface EventManagerService {
	/**
	 * @abstract:待处理事件_当用户对系统回复的答案不满意时，即tbl_robotAnswer问答表中满意字段置为0
	 */
	List<EventView> eventUnresolved(int saticfaction, int questionstate);
	
	/**
	 * abstract:事件未处理_忽略用户问题 2是忽略
	 */
	void updateQuestionState(String userQuestionId, int questionState);
	
	/**
	 * abstract:已处理事件_当用户对系统回复的答案满意时，即tbl_robotAnswer问答表中满意字段置为1
	 */
//	List<Event_AnswerView> eventResolved();
	
	/**
	 * abstract:事件已处理_查看事件详情_showResolvedEvent.ftl
	 */
	Event_AnswerView getResolvedEventDetail(String userQuestionId);
	
	/**
	 * abstract:事件待处理_查看事件详情
	 * 
	 */
	EventView getUnResolvedEventDetail(String userQuestionId);
}
