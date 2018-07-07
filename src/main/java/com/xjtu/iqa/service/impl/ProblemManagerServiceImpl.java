package com.xjtu.iqa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.CommunityQuestionMapper;
import com.xjtu.iqa.mapper.FaqClassifyMapper;
import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.po.CommunityQuestion;
import com.xjtu.iqa.service.ProblemManagerService;
import com.xjtu.iqa.vo.ProblemView;

@Service
public class ProblemManagerServiceImpl implements ProblemManagerService {
	@Autowired
	CommunityQuestionMapper communityQuestionMapper;
	@Autowired
	FaqClassifyMapper faqClassifyMapper;
	@Autowired
	UserMapper userMapper;

	@Override
	public List<ProblemView> problemUnresolved(int isanswer, int questionState) {
		// 问题未处理视图_2017年11月6日09:14:03
		List<ProblemView> problemUnresolveds = new ArrayList<ProblemView>();

		// 获取问题中心中所有没有最佳答案的问题信息
		List<CommunityQuestion> problemUnresolvedLists = communityQuestionMapper.problemInfo(isanswer, questionState);

		for (CommunityQuestion problemUnresolvedList : problemUnresolvedLists) {
			ProblemView problemUnresolved = new ProblemView();

			problemUnresolved.setProblemId(problemUnresolvedList.getCOMMUNITYQUESTIONID());
			problemUnresolved.setProblemTitle(problemUnresolvedList.getTITLE());
			problemUnresolved.setProblemContent(problemUnresolvedList.getCONTENT());

			String classifyName = faqClassifyMapper.getClassifyNameById(problemUnresolvedList.getCLASSIFYID());
			problemUnresolved.setProblemClassifyName(classifyName);

			String username = userMapper.selectByPrimaryKey(problemUnresolvedList.getUSERID()).getUSERNAME();
			problemUnresolved.setProblemUserName(username);
			problemUnresolved.setProblemTime(problemUnresolvedList.getTIME());

			problemUnresolveds.add(problemUnresolved);
		}
		return problemUnresolveds;
	}

}
