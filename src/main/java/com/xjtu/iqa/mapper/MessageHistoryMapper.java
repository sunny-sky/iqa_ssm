package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.MessageHistory;
import com.xjtu.iqa.po.MessageHistoryExample;

public interface MessageHistoryMapper {
    int deleteByPrimaryKey(String MESSAGEHISTORYID);

    int insert(MessageHistory record);

    int insertSelective(MessageHistory record);

    List<MessageHistory> selectByExample(MessageHistoryExample example);

    MessageHistory selectByPrimaryKey(String MESSAGEHISTORYID);

    int updateByPrimaryKeySelective(MessageHistory record);

    int updateByPrimaryKey(MessageHistory record);
}