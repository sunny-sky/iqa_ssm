package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.FaqAnswer;
import com.xjtu.iqa.pojo.FaqAnswerExample;
import java.util.List;

public interface FaqAnswerMapper {
    int deleteByPrimaryKey(String FAQANSWERID);

    int insert(FaqAnswer record);

    int insertSelective(FaqAnswer record);

    List<FaqAnswer> selectByExampleWithBLOBs(FaqAnswerExample example);

    List<FaqAnswer> selectByExample(FaqAnswerExample example);

    FaqAnswer selectByPrimaryKey(String FAQANSWERID);

    int updateByPrimaryKeySelective(FaqAnswer record);

    int updateByPrimaryKeyWithBLOBs(FaqAnswer record);

    int updateByPrimaryKey(FaqAnswer record);
}