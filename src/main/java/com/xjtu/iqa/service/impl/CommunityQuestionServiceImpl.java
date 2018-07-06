package com.xjtu.iqa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.CommunityQuestionMapper;
import com.xjtu.iqa.po.CommunityQuestion;
import com.xjtu.iqa.po.CommunityQuestionExample;
import com.xjtu.iqa.service.CommunityQuestionService;

@Service
public class CommunityQuestionServiceImpl implements CommunityQuestionService {
	@Autowired
	CommunityQuestionMapper communityQuestionMapper;
	
	
	@Override
	public void add(CommunityQuestion cq){
		communityQuestionMapper.insert(cq);
	}
	
	@Override
	public void delete(String id){
		communityQuestionMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public CommunityQuestion get(String id){
		return communityQuestionMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public void update(CommunityQuestion cq){
		communityQuestionMapper.updateByPrimaryKey(cq);
	}
	
	//返回isanswe=0且questionStatus=1的所有CommunityQuestion,即待处理问题
	@Override
	public List<CommunityQuestion> problemUnresolved(){
		CommunityQuestionExample example = new CommunityQuestionExample();
    	example.createCriteria().andISANSWEREqualTo(0).andQUESTIONSTATEEqualTo(1);
    	example.setOrderByClause("COMMUNITYQUESTIONID desc");
    	List<CommunityQuestion> cqs = communityQuestionMapper.selectByExample(example);
    	return cqs;
	}
}
