package com.xjtu.iqa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.mapper.UserQuestionMapper;
import com.xjtu.iqa.po.UserQuestion;
import com.xjtu.iqa.service.EventManagerService;
import com.xjtu.iqa.vo.EventView;

@Service
public class EventManagerServiceImpl implements EventManagerService {
	@Autowired
	UserQuestionMapper userQuestionMapper;
	@Autowired
	UserMapper userMapper;
	
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
}
