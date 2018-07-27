package com.xjtu.iqa.service;

public interface FaqQuestionService {
	/**
	 * 待审核faq审核通过
	 * @param faqState 状态  1 -- 待审核；2 -- 通过审核
	 */
	void updateFaqInfo(String questionId, String keywords, String description, int faqState, String faqcontent);
	
	/**
	 * abstract:FAQ的增加
	 * !!!可补充 两个userId注意区分
	 */
	void saveFAQ(String username, String title, String keywords, String subspecialCategoryId,String description, String faqcontent, String userQuestionId);
	
	/**
	 * @param answerUser 
	 * @abstract 保存社区有最佳答案问题到知识库
	 * questionState  0:正常显示，1：已加入faq，2：已忽略!!!
	 */
	void saveCommunityQuestionToFAQ(String faqTitle, String faqKeyWords, String faqclassifyId,
		String modifyTime, String faqDescription, String userId, String answerContent, String communityProblemId, String answerUser);
}
