package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Log;
import com.xjtu.iqa.po.LogExample;

public interface LogMapper {
    int deleteByPrimaryKey(String LOGID);

    int insert(Log record);

    int insertSelective(Log record);

    List<Log> selectByExample(LogExample example);

    Log selectByPrimaryKey(String LOGID);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}