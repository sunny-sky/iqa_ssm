package com.xjtu.iqa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.FaqQuestionMapper;
import com.xjtu.iqa.po.FaqQuestion;
import com.xjtu.iqa.po.FaqQuestionExample;
import com.xjtu.iqa.service.FaqQuestionService;

@Service
public class FaqQuestionServiceImpl implements FaqQuestionService{
	@Autowired
	FaqQuestionMapper faqQuestionMapper;
	
	@Override
    public void add(FaqQuestion ra) {
		faqQuestionMapper.insert(ra);
    }
    
    @Override
    public void delete(String id) {
    	faqQuestionMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public void update(FaqQuestion ra) {
    	faqQuestionMapper.updateByPrimaryKeySelective(ra);
    }
    
    @Override
    public FaqQuestion get(String id) {
        return faqQuestionMapper.selectByPrimaryKey(id);
    }
    
    //获取所有待审核faqquestion表中FAQSTATE字段为1的faq，即待处理faq
    @Override
    public List<FaqQuestion> faqPendingAudits(){
    	FaqQuestionExample example = new FaqQuestionExample();
    	example.createCriteria().andFAQSTATEEqualTo(1);
    	example.setOrderByClause("FAQQUESTIONID desc");
    	List<FaqQuestion> fqs =faqQuestionMapper.selectByExample(example);
    	return fqs;
    }
}
