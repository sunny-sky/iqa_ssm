package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.FaqQuestion;
import com.xjtu.iqa.pojo.FaqQuestionExample;
import java.util.List;

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