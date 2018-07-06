package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.FaqQuestion;
import com.xjtu.iqa.po.FaqQuestionExample;

public interface FaqQuestionMapper {
    int deleteByPrimaryKey(String FAQQUESTIONID);

    int insert(FaqQuestion record);

    int insertSelective(FaqQuestion record);

    List<FaqQuestion> selectByExampleWithBLOBs(FaqQuestionExample example);

    List<FaqQuestion> selectByExample(FaqQuestionExample example);

    FaqQuestion selectByPrimaryKey(String FAQQUESTIONID);

    int updateByPrimaryKeySelective(FaqQuestion record);

    int updateByPrimaryKeyWithBLOBs(FaqQuestion record);

    int updateByPrimaryKey(FaqQuestion record);
}