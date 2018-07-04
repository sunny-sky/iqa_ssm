package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Robot;
import com.xjtu.iqa.pojo.RobotExample;
import java.util.List;

public interface RobotMapper {
    int deleteByPrimaryKey(String ROBOTID);

    int insert(Robot record);

    int insertSelective(Robot record);

    List<Robot> selectByExample(RobotExample example);

    Robot selectByPrimaryKey(String ROBOTID);

    int updateByPrimaryKeySelective(Robot record);

    int updateByPrimaryKey(Robot record);
}