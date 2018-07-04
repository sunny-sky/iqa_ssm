package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.UserQuestion;
import com.xjtu.iqa.pojo.UserQuestionExample;
import java.util.List;

public interface UserQuestionMapper {
    int deleteByPrimaryKey(String USERQUESTIONID);

    int insert(UserQuestion record);

    int insertSelective(UserQuestion record);

    List<UserQuestion> selectByExample(UserQuestionExample example);

    UserQuestion selectByPrimaryKey(String USERQUESTIONID);

    int updateByPrimaryKeySelective(UserQuestion record);

    int updateByPrimaryKey(UserQuestion record);
}