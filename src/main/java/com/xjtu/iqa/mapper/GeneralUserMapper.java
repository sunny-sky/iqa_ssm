package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.GeneralUser;
import com.xjtu.iqa.po.GeneralUserExample;

public interface GeneralUserMapper {
    int deleteByPrimaryKey(String USERID);

    int insert(GeneralUser record);

    int insertSelective(GeneralUser record);

    List<GeneralUser> selectByExample(GeneralUserExample example);

    GeneralUser selectByPrimaryKey(String USERID);

    int updateByPrimaryKeySelective(GeneralUser record);

    int updateByPrimaryKey(GeneralUser record);
}