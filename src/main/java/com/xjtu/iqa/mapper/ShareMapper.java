package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Share;
import com.xjtu.iqa.po.ShareExample;

public interface ShareMapper {
    int deleteByPrimaryKey(String SHAREID);

    int insert(Share record);

    int insertSelective(Share record);

    List<Share> selectByExample(ShareExample example);

    Share selectByPrimaryKey(String SHAREID);

    int updateByPrimaryKeySelective(Share record);

    int updateByPrimaryKey(Share record);
}