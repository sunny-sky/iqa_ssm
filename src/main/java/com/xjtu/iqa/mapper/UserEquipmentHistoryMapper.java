package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.UserEquipmentHistory;
import com.xjtu.iqa.po.UserEquipmentHistoryExample;

public interface UserEquipmentHistoryMapper {
    int deleteByPrimaryKey(String USEREQUIPMENTHISTORYID);

    int insert(UserEquipmentHistory record);

    int insertSelective(UserEquipmentHistory record);

    List<UserEquipmentHistory> selectByExample(UserEquipmentHistoryExample example);

    UserEquipmentHistory selectByPrimaryKey(String USEREQUIPMENTHISTORYID);

    int updateByPrimaryKeySelective(UserEquipmentHistory record);

    int updateByPrimaryKey(UserEquipmentHistory record);
}