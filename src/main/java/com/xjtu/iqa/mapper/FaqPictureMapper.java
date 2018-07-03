package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.FaqPicture;
import com.xjtu.iqa.pojo.FaqPictureExample;
import java.util.List;

public interface FaqPictureMapper {
    int deleteByPrimaryKey(String FAQPICTUREID);

    int insert(FaqPicture record);

    int insertSelective(FaqPicture record);

    List<FaqPicture> selectByExample(FaqPictureExample example);

    FaqPicture selectByPrimaryKey(String FAQPICTUREID);

    int updateByPrimaryKeySelective(FaqPicture record);

    int updateByPrimaryKey(FaqPicture record);
}