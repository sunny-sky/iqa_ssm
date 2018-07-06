package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.FaqClassify;
import com.xjtu.iqa.po.FaqClassifyExample;

public interface FaqClassifyMapper {
    int deleteByPrimaryKey(String FAQCLASSIFYID);

    int insert(FaqClassify record);

    int insertSelective(FaqClassify record);

    List<FaqClassify> selectByExample(FaqClassifyExample example);

    FaqClassify selectByPrimaryKey(String FAQCLASSIFYID);

    int updateByPrimaryKeySelective(FaqClassify record);

    int updateByPrimaryKey(FaqClassify record);
}