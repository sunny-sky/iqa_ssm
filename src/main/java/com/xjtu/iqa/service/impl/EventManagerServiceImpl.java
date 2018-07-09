package com.xjtu.iqa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.FaqAnswerMapper;
import com.xjtu.iqa.mapper.RobotAnswerMapper;
import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.mapper.UserQuestionMapper;
import com.xjtu.iqa.po.UserQuestion;
import com.xjtu.iqa.service.EventManagerService;
import com.xjtu.iqa.vo.EventView;
import com.xjtu.iqa.vo.Event_AnswerView;

@Service
public class EventManagerServiceImpl implements EventManagerService {
	@Autowired
	UserQuestionMapper userQuestionMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	RobotAnswerMapper robotAnswerMapper;
	@Autowired
	FaqAnswerMapper faqAnswerMapper;
	
	@Override
	public List<EventView> eventUnresolved(int saticfaction, int questionstate) {
		// 未处理视图
		List<EventView> eventUnresolved = new ArrayList<EventView>();
		// !!! 分页
		// 事件就是处理用户前台问题_获取所有有满意度且满意度为0的前台问题
		List<UserQuestion> userQuestions = userQuestionMapper.resolvedEvent(saticfaction, questionstate);

		for (UserQuestion userQuestion : userQuestions) {
			EventView eventView = new EventView();
			eventView.setUserQuestionTitle(userQuestion.getQUESTIONTITLE());
			String username = userMapper.selectByPrimaryKey(userQuestion.getUSERID()).getUSERNAME();
			eventView.setUserName(username);
			eventView.setUserQuestionTime(userQuestion.getQUESTIONTIME());
			eventView.setUserQuestionId(userQuestion.getUSERQUESTIONID());
			eventUnresolved.add(eventView);
		}
		return eventUnresolved;
	}
	
	@Override
	public Event_AnswerView getResolvedEventDetail(String userQuestionId){
		//已处理事件视图
				Event_AnswerView event_AnswerView = new Event_AnswerView();
				//获取查看的用户问题
				List<UserQuestion> userQuestionPersistences = userQuestionMapper.getUserQuestionById(userQuestionId);
						
				event_AnswerView.setUSERQUESTIONID(userQuestionId);
				event_AnswerView.setQUESTIONTITLE(userQuestionPersistences.get(0).getQUESTIONTITLE());		
				//获取应答表中问题对应的知识库答案id
				String faqAnswerId = robotAnswerMapper.getFaqAnswerIdByQuestionId(userQuestionId);		
				//获取faqanswerId相对应的内容
				String faqContent = faqAnswerMapper.getContentById(faqAnswerId);
				event_AnswerView.setFAQANSWER(faqContent);
				//获取用户名信息
				String username = userMapper.getUserNameById(userQuestionPersistences.get(0).getUSERID());
				event_AnswerView.setUSERNAME(username);
				event_AnswerView.setQUESTIONTIME(userQuestionPersistences.get(0).getQUESTIONTIME());
				return event_AnswerView;
	}
	

	//abstract:事件待处理_查看事件详情

	@Override
	public EventView getUnResolvedEventDetail(String userQuestionId) {
		
		//获取查看的问题信息
		List<UserQuestion> userQuestions = userQuestionMapper.getUserQuestionById(userQuestionId);
		
		EventView eventView = new EventView();
		
		eventView.setUserQuestionId(userQuestionId);
		eventView.setUserQuestionTime(userQuestions.get(0).getQUESTIONTIME());
		
		eventView.setUserQuestionTitle(userQuestions.get(0).getQUESTIONTITLE());
		String username = userMapper.getUserNameById(userQuestions.get(0).getUSERID());
		eventView.setUserName(username);	
	
		return eventView;
	}
}
