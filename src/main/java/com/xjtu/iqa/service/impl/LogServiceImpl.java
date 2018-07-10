package com.xjtu.iqa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.LogMapper;
import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.po.Log;
import com.xjtu.iqa.po.User;
import com.xjtu.iqa.service.LogService;
import com.xjtu.iqa.vo.logindexView;

@Service
public class LogServiceImpl implements LogService{
	@Autowired
	LogMapper logMapper;
	@Autowired
	UserMapper userMapper;

	/**
	 * zpz_knowledgeindex_FAQ的展示
	 */
	public List<logindexView> logindexViews(int startnum,int count){
		List<logindexView> logindexViews = new ArrayList<logindexView>();
		List<Log> logPersistences = logMapper.getLog(startnum,count);
		for(Log logPersistence:logPersistences){
			logindexView logindexView = new logindexView();
			logindexView.setLogMethod(logPersistence.getLOGMETHOD());
			logindexView.setLogTime(logPersistence.getLOGTIME());
			List<User> userPersistences = userMapper.getUserInfoById(logPersistence.getUSERID());
			logindexView.setLogUser(userPersistences.get(0).getUSERNAME()); 
			logindexViews.add(logindexView);
		}
		return logindexViews;
	}
}
