package com.xjtu.iqa.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.CommunityQuestionMapper;
import com.xjtu.iqa.mapper.FaqAnswerMapper;
import com.xjtu.iqa.mapper.FaqQuestionMapper;
import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.po.FaqAnswer;
import com.xjtu.iqa.po.FaqQuestion;
import com.xjtu.iqa.service.FaqQuestionService;

@Service
public class FaqQuestionServiceImpl implements FaqQuestionService{
	@Autowired
	FaqQuestionMapper faqQuestionMapper;
	@Autowired
	FaqAnswerMapper faqAnswerMapper; 
	@Autowired
	UserMapper userMapper;
	@Autowired
	CommunityQuestionMapper communityQuestionMapper;
	
	/**
	 * 待审核faq审核通过
	 * @param faqState 状态  1 -- 待审核；2 -- 通过审核
	 */
	@Override
	public void updateFaqInfo(String questionId, String keywords, String description, int faqState, String faqcontent) {
		//获取原始待审核faq问题信息
		List<FaqQuestion> faqQuestionInfo = faqQuestionMapper.getFaqQuestionInfo(questionId);		
		//获取原始待审核faq答案信息
		String faqOriginalContent = faqAnswerMapper.getContentByQuestionId(questionId);
		//判断管理员有无对待审核faq进行更改
		if ((faqQuestionInfo.get(0).getFAQKEYWORDS() == keywords) &&(faqQuestionInfo.get(0).getFAQDESCRIPTION() == description) && (faqOriginalContent == faqcontent)) {
			//管理员未更改用户提交faq
			String modifyNum = faqQuestionInfo.get(0).getMODIFYNUMBER();			
			//更新faq问题表
			faqQuestionMapper.updateFaqInfo1(questionId,modifyNum,faqState );			
		}else {
			//管理员对待审核faq修改后进行提交
			String modifyNum = faqQuestionInfo.get(0).getMODIFYNUMBER();
			int modifyNum1 = Integer.parseInt(modifyNum) + 1;
			String modifyNum2 = Integer.toString(modifyNum1);						
			//更新faq问题表
			faqQuestionMapper.updateFaqInfo(questionId, keywords, description, modifyNum2,faqState );			
			//更新faq答案表
			faqAnswerMapper.updateFaqAnswerInfo(questionId,faqcontent);
		}
	}
	
	/**
	 * abstract:FAQ的增加
	 * !!!可补充 两个userId注意区分
	 */
	@Override
	public void saveFAQ(String username, String title, String keywords, String subspecialCategoryId,String description, String faqcontent, String userQuestionId) {	
		FaqQuestion questionPersistence = new FaqQuestion();
		
		String questionId = UUID.randomUUID().toString();
    	Date date=new Date();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time = format.format(date);
		String userId = userMapper.getUserIdByName(username);

		questionPersistence.setFAQQUESTIONID(questionId);
		questionPersistence.setFAQTITLE(title);
		questionPersistence.setFAQKEYWORDS(keywords);
		questionPersistence.setFAQCLASSIFYID(subspecialCategoryId);
		questionPersistence.setCOLLECTION("0");
		questionPersistence.setSCAN("0");
		questionPersistence.setMODIFYTIME(time);
		questionPersistence.setFAQDESCRIPTION(description);
		questionPersistence.setMODIFYNUMBER("1");
		questionPersistence.setFAQSTATE(2);
		questionPersistence.setUSERID(userId);

		faqQuestionMapper.insert(questionPersistence);
		System.out.println("问题表插入完毕1");
		
		FaqAnswer answerPersistence = new FaqAnswer();
		answerPersistence.setFAQANSWERID(UUID.randomUUID().toString());
		answerPersistence.setFAQCONTENT(faqcontent);
		answerPersistence.setFAQQUESTIONID(questionId);
		answerPersistence.setUSERID(userId);
		faqAnswerMapper.insert(answerPersistence);		
		//添加至知识库答案列表
		System.out.println("答案表插入完毕1");
			
	}
	
	/**
	 * @param answerUser 
	 * @abstract 保存社区有最佳答案问题到知识库
	 * questionState  0:正常显示，1：已加入faq，2：已忽略!!!
	 */
	@Override
	public void saveCommunityQuestionToFAQ(String faqTitle, String faqKeyWords, String faqclassifyId,
		String modifyTime, String faqDescription, String userId, String answerContent, String communityProblemId, String answerUser) {		
		FaqQuestion questionPersistence = new FaqQuestion();
	
    	Date date=new Date();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time = format.format(date);

		questionPersistence.setFAQQUESTIONID(communityProblemId);
		questionPersistence.setFAQTITLE(faqTitle);
		questionPersistence.setFAQKEYWORDS(faqKeyWords);
		questionPersistence.setFAQCLASSIFYID(faqKeyWords);
		questionPersistence.setCOLLECTION("0");
		questionPersistence.setSCAN("0");
		questionPersistence.setMODIFYTIME(time);
		questionPersistence.setFAQDESCRIPTION(faqDescription);
		questionPersistence.setMODIFYNUMBER("1");
		questionPersistence.setFAQSTATE(2);
		questionPersistence.setUSERID(userId);

		faqQuestionMapper.insert(questionPersistence);
		System.out.println("问题表插入完毕1");
		
		FaqAnswer answerPersistence = new FaqAnswer();
		answerPersistence.setFAQANSWERID(UUID.randomUUID().toString());
		answerPersistence.setFAQCONTENT(answerContent);
		answerPersistence.setFAQQUESTIONID(communityProblemId);
		String answerUserid = userMapper.getUserIdByName(answerUser);
		answerPersistence.setUSERID(answerUserid);
		faqAnswerMapper.insert(answerPersistence);		

		System.out.println("答案表插入完毕");
		
		//UserfaqQuestionMapper.updateRobotAnswerState(userQuestionId,1);
		communityQuestionMapper.updateCommunityQuestionState(communityProblemId, 1);
		System.out.println("已更新状态");
	}
}
