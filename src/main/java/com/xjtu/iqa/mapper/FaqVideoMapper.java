package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.FaqVideo;
import com.xjtu.iqa.pojo.FaqVideoExample;
import java.util.List;

public interface FaqVideoMapper {
    int deleteByPrimaryKey(String FAQVIDEOID);

    int insert(FaqVideo record);

    int insertSelective(FaqVideo record);

    List<FaqVideo> selectByExample(FaqVideoExample example);

    FaqVideo selectByPrimaryKey(String FAQVIDEOID);

    int updateByPrimaryKeySelective(FaqVideo record);

    int updateByPrimaryKey(FaqVideo record);
}