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
}