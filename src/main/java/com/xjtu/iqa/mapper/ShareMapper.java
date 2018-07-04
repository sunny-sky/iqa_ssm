package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Share;
import com.xjtu.iqa.pojo.ShareExample;
import java.util.List;

public interface ShareMapper {
    int deleteByPrimaryKey(String SHAREID);

    int insert(Share record);

    int insertSelective(Share record);

    List<Share> selectByExample(ShareExample example);

    Share selectByPrimaryKey(String SHAREID);

    int updateByPrimaryKeySelective(Share record);

    int updateByPrimaryKey(Share record);
}