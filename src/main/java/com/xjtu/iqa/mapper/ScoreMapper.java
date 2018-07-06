package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Score;
import com.xjtu.iqa.po.ScoreExample;

public interface ScoreMapper {
    int deleteByPrimaryKey(String SCOREID);

    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    Score selectByPrimaryKey(String SCOREID);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}