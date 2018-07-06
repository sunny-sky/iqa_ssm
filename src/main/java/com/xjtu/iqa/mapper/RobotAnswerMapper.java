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
}