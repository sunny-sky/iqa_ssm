package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.RobotAnswer;
import com.xjtu.iqa.po.RobotAnswerExample;

public interface RobotAnswerMapper {
    int deleteByPrimaryKey(String ROBOTANSWERID);

    int insert(RobotAnswer record);

    int insertSelective(RobotAnswer record);

    List<RobotAnswer> selectByExample(RobotAnswerExample example);

    RobotAnswer selectByPrimaryKey(String ROBOTANSWERID);

    int updateByPrimaryKeySelective(RobotAnswer record);

    int updateByPrimaryKey(RobotAnswer record);
    
  //查看是否已填写过满意度
  	String getQuertionInfo(String questionId);
  	
  	//更新已处理的状态
  	void updateRobotAnswerState(String questionId, int questionState);
  	
  	//zzl_获取应答表中问题对应的知识库答案id_2017年11月4日21:31:49
  	String getFaqAnswerIdByQuestionId(String userQuestionId);
}