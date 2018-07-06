package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.pojo.CommunityQuestion;

public interface CommunityQuestionService {

	void add(CommunityQuestion cq);
	void delete(String id);
	CommunityQuestion get(String id);
    void update(CommunityQuestion ra);
    
  //返回isanswe=0且questionStatus=1的所有CommunityQuestion,即待处理问题
    List<CommunityQuestion> problemUnresolved();
}
