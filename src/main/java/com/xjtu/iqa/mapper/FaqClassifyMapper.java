package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.FaqClassify;
import com.xjtu.iqa.pojo.FaqClassifyExample;
import java.util.List;

public interface FaqClassifyMapper {
    int deleteByPrimaryKey(String FAQCLASSIFYID);

    int insert(FaqClassify record);

    int insertSelective(FaqClassify record);

    List<FaqClassify> selectByExample(FaqClassifyExample example);

    FaqClassify selectByPrimaryKey(String FAQCLASSIFYID);

    int updateByPrimaryKeySelective(FaqClassify record);

    int updateByPrimaryKey(FaqClassify record);
}