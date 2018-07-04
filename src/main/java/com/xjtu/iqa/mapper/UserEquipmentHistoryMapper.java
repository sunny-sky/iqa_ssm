package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.UserEquipmentHistory;
import com.xjtu.iqa.pojo.UserEquipmentHistoryExample;
import java.util.List;

public interface UserEquipmentHistoryMapper {
    int deleteByPrimaryKey(String USEREQUIPMENTHISTORYID);

    int insert(UserEquipmentHistory record);

    int insertSelective(UserEquipmentHistory record);

    List<UserEquipmentHistory> selectByExample(UserEquipmentHistoryExample example);

    UserEquipmentHistory selectByPrimaryKey(String USEREQUIPMENTHISTORYID);

    int updateByPrimaryKeySelective(UserEquipmentHistory record);

    int updateByPrimaryKey(UserEquipmentHistory record);
}