package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.CommunityAnswer;
import com.xjtu.iqa.po.CommunityAnswerExample;

public interface CommunityAnswerMapper {
    int deleteByPrimaryKey(String COMMUNITYANSWERID);

    int insert(CommunityAnswer record);

    int insertSelective(CommunityAnswer record);

    List<CommunityAnswer> selectByExampleWithBLOBs(CommunityAnswerExample example);

    List<CommunityAnswer> selectByExample(CommunityAnswerExample example);

    CommunityAnswer selectByPrimaryKey(String COMMUNITYANSWERID);

    int updateByPrimaryKeySelective(CommunityAnswer record);

    int updateByPrimaryKeyWithBLOBs(CommunityAnswer record);

    int updateByPrimaryKey(CommunityAnswer record);
}