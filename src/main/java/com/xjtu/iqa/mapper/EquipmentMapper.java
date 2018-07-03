package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Equipment;
import com.xjtu.iqa.pojo.EquipmentExample;
import java.util.List;

public interface EquipmentMapper {
    int deleteByPrimaryKey(String EQUIPMENTID);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    List<Equipment> selectByExample(EquipmentExample example);

    Equipment selectByPrimaryKey(String EQUIPMENTID);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
}