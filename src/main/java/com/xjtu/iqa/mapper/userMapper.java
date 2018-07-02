package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.user;
import com.xjtu.iqa.pojo.userExample;
import java.util.List;

public interface userMapper {
    int deleteByPrimaryKey(String USERID);

    int insert(user record);

    int insertSelective(user record);

    List<user> selectByExample(userExample example);

    user selectByPrimaryKey(String USERID);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}