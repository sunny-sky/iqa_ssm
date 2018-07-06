package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.User;
import com.xjtu.iqa.po.UserExample;

public interface UserMapper {
    int deleteByPrimaryKey(String USERID);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String USERID);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}