package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.pojo.RobotAnswer;


public interface RobotAnswerService {
	void add(RobotAnswer ra);    
    void delete(String id);
    RobotAnswer get(String id);
    void update(RobotAnswer ra);
    
    //待处理事件_当用户对系统回复的答案不满意时，即tbl_robotAnswer问答表中满意字段置为0，
    //1，查不满意回复个数
    //2，返回不满意回复问题（处理问题放在问题service中）
    List<RobotAnswer> Unresolved();

}
