package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.User;
import com.xjtu.iqa.pojo.UserExample;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String USERID);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String USERID);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}