package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.CommunityQuestion;
import com.xjtu.iqa.po.CommunityQuestionExample;

public interface CommunityQuestionMapper {
    int deleteByPrimaryKey(String COMMUNITYQUESTIONID);

    int insert(CommunityQuestion record);

    int insertSelective(CommunityQuestion record);

    List<CommunityQuestion> selectByExampleWithBLOBs(CommunityQuestionExample example);

    List<CommunityQuestion> selectByExample(CommunityQuestionExample example);

    CommunityQuestion selectByPrimaryKey(String COMMUNITYQUESTIONID);

    int updateByPrimaryKeySelective(CommunityQuestion record);

    int updateByPrimaryKeyWithBLOBs(CommunityQuestion record);

    int updateByPrimaryKey(CommunityQuestion record);
}