package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Equipment;
import com.xjtu.iqa.po.EquipmentExample;

public interface EquipmentMapper {
    int deleteByPrimaryKey(String EQUIPMENTID);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    List<Equipment> selectByExample(EquipmentExample example);

    Equipment selectByPrimaryKey(String EQUIPMENTID);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
}