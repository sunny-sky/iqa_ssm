package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Message;
import com.xjtu.iqa.po.MessageExample;

public interface MessageMapper {
    int deleteByPrimaryKey(String MESSAGEID);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(String MESSAGEID);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}