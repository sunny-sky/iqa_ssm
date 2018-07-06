package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.EquipmentBasicConfigure;
import com.xjtu.iqa.po.EquipmentBasicConfigureExample;

public interface EquipmentBasicConfigureMapper {
    int deleteByPrimaryKey(String EQUIPMENTBASICCONFIGUREID);

    int insert(EquipmentBasicConfigure record);

    int insertSelective(EquipmentBasicConfigure record);

    List<EquipmentBasicConfigure> selectByExample(EquipmentBasicConfigureExample example);

    EquipmentBasicConfigure selectByPrimaryKey(String EQUIPMENTBASICCONFIGUREID);

    int updateByPrimaryKeySelective(EquipmentBasicConfigure record);

    int updateByPrimaryKey(EquipmentBasicConfigure record);
}