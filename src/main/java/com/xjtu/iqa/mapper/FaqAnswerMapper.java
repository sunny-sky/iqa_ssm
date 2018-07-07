package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.FaqAnswer;
import com.xjtu.iqa.po.FaqAnswerExample;

public interface FaqAnswerMapper {
	int deleteByPrimaryKey(String FAQANSWERID);

	int insert(FaqAnswer record);

	int insertSelective(FaqAnswer record);

	List<FaqAnswer> selectByExampleWithBLOBs(FaqAnswerExample example);

	List<FaqAnswer> selectByExample(FaqAnswerExample example);

	FaqAnswer selectByPrimaryKey(String FAQANSWERID);

	int updateByPrimaryKeySelective(FaqAnswer record);

	int updateByPrimaryKeyWithBLOBs(FaqAnswer record);

	int updateByPrimaryKey(FaqAnswer record);

	// zyq_faq3_知识内容
	List<FaqAnswer> getAnswerByQuestionId(String QuestionId);

	// 根据faq问题id查找用户id
	String findUserIdByFAQQuestionId(String faqquestionid);

	/********************************************* 后台 ***************************************************************/
	// 获取faqanswerId相对应的内容
	String getContentById(String faqAnswerId);

	// 根据问题id获取问题答案内容
	String getContentByQuestionId(String faqquestionid);

	// 更新faq信息
	void updateFaqAnswerInfo(String questionId, String faqcontent);

	/**
	 * zyq_notice_ajax_查询FAQ评论通知 !!!未使用
	 */
	List<FaqAnswer> notice_faqanswerList(String userId);

}