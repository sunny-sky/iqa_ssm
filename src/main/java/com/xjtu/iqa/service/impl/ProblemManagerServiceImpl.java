package com.xjtu.iqa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.CommunityAnswerMapper;
import com.xjtu.iqa.mapper.CommunityQuestionMapper;
import com.xjtu.iqa.mapper.FaqClassifyMapper;
import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.po.CommunityAnswer;
import com.xjtu.iqa.po.CommunityQuestion;
import com.xjtu.iqa.po.FaqClassify;
import com.xjtu.iqa.po.User;
import com.xjtu.iqa.service.ProblemManagerService;
import com.xjtu.iqa.vo.ProblemView;
import com.xjtu.iqa.vo.Problem_AnswerView;

@Service
public class ProblemManagerServiceImpl implements ProblemManagerService {
	@Autowired
	CommunityQuestionMapper communityQuestionMapper;
	@Autowired
	FaqClassifyMapper faqClassifyMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	CommunityAnswerMapper communityAnswerMapper;

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
	
	
	/**
	 * @abstract 获取问题中心有最佳答案的问题
	 * @return problemResolveds
	 */
	@Override
	public List<Problem_AnswerView> problemResolved(int isanswer, int questionState) {
		// 有最佳答案视图
		List<Problem_AnswerView> problemResolveds = new ArrayList<Problem_AnswerView>();

		// 获取问题中心中所有有最佳答案的问题信息
		List<CommunityQuestion> problemResolvedLists = communityQuestionMapper.problemInfo(isanswer,questionState);

		for (CommunityQuestion problemResolvedList : problemResolvedLists) {
			Problem_AnswerView problem_AnswerView = new Problem_AnswerView();

			problem_AnswerView.setProblemId(problemResolvedList.getCOMMUNITYQUESTIONID());
			problem_AnswerView.setProblemTitle(problemResolvedList.getTITLE());
			problem_AnswerView.setProblemContent(problemResolvedList.getCONTENT());

			List<FaqClassify> classifyPersistences = faqClassifyMapper.getInfoById(problemResolvedList.getCLASSIFYID());
			problem_AnswerView.setProblemClassifyName(classifyPersistences.get(0).getFAQCLASSIFYNAME());

			List<User> userPersistences = userMapper.getUserInfoById(problemResolvedList.getUSERID());
			problem_AnswerView.setProblemUserName(userPersistences.get(0).getUSERNAME());
			problem_AnswerView.setProblemTime(problemResolvedList.getTIME());

			// 查询社区回复者信息
			List<CommunityAnswer> communityAnswerPersistences = communityAnswerMapper.question_iscurrentAnswer(problemResolvedList.getCOMMUNITYQUESTIONID(), 1);
			List<User> ulist = userMapper.getUserInfoById(communityAnswerPersistences.get(0).getUSERID());
			problem_AnswerView.setAnswerUserName(ulist.get(0).getUSERNAME());
			problem_AnswerView.setAnswerTime(communityAnswerPersistences.get(0).getTIME());
			problem_AnswerView.setAnswerContent(communityAnswerPersistences.get(0).getCONTENT());

			problemResolveds.add(problem_AnswerView);
		}
		return problemResolveds;
	}
	
	/**
	 * 忽略问题
	 */
	@Override
	public void updateCommunityQuestionState(String questionId, int questionState) {
		communityQuestionMapper.updateCommunityQuestionState(questionId, questionState);
	}
	
	/**
	 * 获取已处理问题具体信息
	 */
	@Override
	public Problem_AnswerView getResolvedEventDetail(String communityProblemId) {
		// 获取查看的问题信息
		List<CommunityQuestion> CommunityQuestion = communityQuestionMapper
				.question2_getCommunity(communityProblemId);

		Problem_AnswerView problem_AnswerView = new Problem_AnswerView();

		problem_AnswerView.setProblemId(communityProblemId);
		problem_AnswerView.setProblemTitle(CommunityQuestion.get(0).getTITLE());
		problem_AnswerView.setProblemContent(CommunityQuestion.get(0).getCONTENT());

		String classifyName = faqClassifyMapper.getClassifyNameById(CommunityQuestion.get(0).getCLASSIFYID());
		problem_AnswerView.setProblemClassifyId(CommunityQuestion.get(0).getCLASSIFYID());
		problem_AnswerView.setProblemClassifyName(classifyName);

		String username = userMapper.getUserNameById(CommunityQuestion.get(0).getUSERID());
		problem_AnswerView.setProblemUserId(CommunityQuestion.get(0).getUSERID());
		problem_AnswerView.setProblemUserName(username);

		problem_AnswerView.setProblemTime(CommunityQuestion.get(0).getTIME());

		// 获取最佳答案信息
		List<CommunityAnswer> communityAnswerPersistences = communityAnswerMapper
				.question_iscurrentAnswer(communityProblemId, 1);

		problem_AnswerView.setAnswerContent(communityAnswerPersistences.get(0).getCONTENT());
		String answerUsername = userMapper.getUserNameById(communityAnswerPersistences.get(0).getUSERID());
		problem_AnswerView.setAnswerUserName(answerUsername);
		problem_AnswerView.setAnswerTime(communityAnswerPersistences.get(0).getTIME());

		return problem_AnswerView;
	}
	
	/**
	 * 获取未处理问题详情
	 */
	@Override
	public ProblemView getUnResolvedEventDetail(String communityProblemId) {
		// 获取查看的问题信息
		List<CommunityQuestion> communityQuestionPersistence = communityQuestionMapper.question2_getCommunity(communityProblemId);

		ProblemView problemView = new ProblemView();

		problemView.setProblemId(communityQuestionPersistence.get(0).getCOMMUNITYQUESTIONID());
		problemView.setProblemTitle(communityQuestionPersistence.get(0).getTITLE());
		problemView.setProblemContent(communityQuestionPersistence.get(0).getCONTENT());

		String classifyName = faqClassifyMapper.getClassifyNameById(communityQuestionPersistence.get(0).getCLASSIFYID());
		problemView.setProblemClassifyName(classifyName);

		String username = userMapper.getUserNameById(communityQuestionPersistence.get(0).getUSERID());
		problemView.setProblemUserName(username);

		problemView.setProblemTime(communityQuestionPersistence.get(0).getTIME());

		return problemView;
	}

}
