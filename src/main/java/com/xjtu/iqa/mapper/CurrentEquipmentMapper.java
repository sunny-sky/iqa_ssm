package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.CurrentEquipment;
import com.xjtu.iqa.po.CurrentEquipmentExample;

public interface CurrentEquipmentMapper {
    int deleteByPrimaryKey(String EQUIPMENTID);

    int insert(CurrentEquipment record);

    int insertSelective(CurrentEquipment record);

    List<CurrentEquipment> selectByExample(CurrentEquipmentExample example);

    CurrentEquipment selectByPrimaryKey(String EQUIPMENTID);

    int updateByPrimaryKeySelective(CurrentEquipment record);

    int updateByPrimaryKey(CurrentEquipment record);
}