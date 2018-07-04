package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.RobotAnswer;
import com.xjtu.iqa.pojo.RobotAnswerExample;
import java.util.List;

public interface RobotAnswerMapper {
    int deleteByPrimaryKey(String ROBOTANSWERID);

    int insert(RobotAnswer record);

    int insertSelective(RobotAnswer record);

    List<RobotAnswer> selectByExample(RobotAnswerExample example);

    RobotAnswer selectByPrimaryKey(String ROBOTANSWERID);

    int updateByPrimaryKeySelective(RobotAnswer record);

    int updateByPrimaryKey(RobotAnswer record);
}