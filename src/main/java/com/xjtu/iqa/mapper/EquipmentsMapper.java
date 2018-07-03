package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Equipments;
import com.xjtu.iqa.pojo.EquipmentsExample;
import java.util.List;

public interface EquipmentsMapper {
    int deleteByPrimaryKey(Integer EQUIPMENT_ID);

    int insert(Equipments record);

    int insertSelective(Equipments record);

    List<Equipments> selectByExample(EquipmentsExample example);

    Equipments selectByPrimaryKey(Integer EQUIPMENT_ID);

    int updateByPrimaryKeySelective(Equipments record);

    int updateByPrimaryKey(Equipments record);
}