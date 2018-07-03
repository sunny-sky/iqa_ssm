package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.GeneralUser;
import com.xjtu.iqa.pojo.GeneralUserExample;
import java.util.List;

public interface GeneralUserMapper {
    int deleteByPrimaryKey(String USERID);

    int insert(GeneralUser record);

    int insertSelective(GeneralUser record);

    List<GeneralUser> selectByExample(GeneralUserExample example);

    GeneralUser selectByPrimaryKey(String USERID);

    int updateByPrimaryKeySelective(GeneralUser record);

    int updateByPrimaryKey(GeneralUser record);
}