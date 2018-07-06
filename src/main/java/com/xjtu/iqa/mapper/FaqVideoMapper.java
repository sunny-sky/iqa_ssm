package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.FaqVideo;
import com.xjtu.iqa.po.FaqVideoExample;

public interface FaqVideoMapper {
    int deleteByPrimaryKey(String FAQVIDEOID);

    int insert(FaqVideo record);

    int insertSelective(FaqVideo record);

    List<FaqVideo> selectByExample(FaqVideoExample example);

    FaqVideo selectByPrimaryKey(String FAQVIDEOID);

    int updateByPrimaryKeySelective(FaqVideo record);

    int updateByPrimaryKey(FaqVideo record);
}