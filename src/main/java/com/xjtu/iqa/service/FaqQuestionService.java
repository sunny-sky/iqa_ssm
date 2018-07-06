package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.po.FaqQuestion;

public interface FaqQuestionService {
	
	void add(FaqQuestion fq);
	void delete(String id);
	FaqQuestion get(String id);
    void update(FaqQuestion fq);
    
    //获取所有待审核faqquestion表中FAQSTATE字段为1的faq，即待处理faq
    List<FaqQuestion> faqPendingAudits();
}
