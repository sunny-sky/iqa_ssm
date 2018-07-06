package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.FaqPicture;
import com.xjtu.iqa.po.FaqPictureExample;

public interface FaqPictureMapper {
    int deleteByPrimaryKey(String FAQPICTUREID);

    int insert(FaqPicture record);

    int insertSelective(FaqPicture record);

    List<FaqPicture> selectByExample(FaqPictureExample example);

    FaqPicture selectByPrimaryKey(String FAQPICTUREID);

    int updateByPrimaryKeySelective(FaqPicture record);

    int updateByPrimaryKey(FaqPicture record);
}