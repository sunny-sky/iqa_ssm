package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.UserQuestion;
import com.xjtu.iqa.po.UserQuestionExample;

public interface UserQuestionMapper {
    int deleteByPrimaryKey(String USERQUESTIONID);

    int insert(UserQuestion record);

    int insertSelective(UserQuestion record);

    List<UserQuestion> selectByExample(UserQuestionExample example);

    UserQuestion selectByPrimaryKey(String USERQUESTIONID);

    int updateByPrimaryKeySelective(UserQuestion record);

    int updateByPrimaryKey(UserQuestion record);
    
    //_获取有满意度且满意度为1的前台问题_2017年11月4日20:47:35
    List<UserQuestion> resolvedEvent(int saticfaction,int questionstate);
    
    //查看前10条待处理问题
  	List<UserQuestion> resolvedEvent_limit(int saticfaction, int questionstate, int num);
  	
  	//获取已处理事件总数
  	int getResolvedCount(int saticfaction,int questionstate);
  	
  	//查找每日待处理事件
  	int eventCount(int saticfaction, int questionstate, String time);
  	
  	//zzl _获取用户问题信息_2017年11月4日21:32:11
  	List<UserQuestion> getUserQuestionById(String userQuestionId);

  	int FindEventViewCountBySaticfaction(int saticfaction, int questionState);
}