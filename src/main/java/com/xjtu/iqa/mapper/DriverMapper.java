package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Driver;
import com.xjtu.iqa.po.DriverExample;

public interface DriverMapper {
    int deleteByPrimaryKey(String CONFIGUREID);

    int insert(Driver record);

    int insertSelective(Driver record);

    List<Driver> selectByExampleWithBLOBs(DriverExample example);

    List<Driver> selectByExample(DriverExample example);

    Driver selectByPrimaryKey(String CONFIGUREID);

    int updateByPrimaryKeySelective(Driver record);

    int updateByPrimaryKeyWithBLOBs(Driver record);

    int updateByPrimaryKey(Driver record);
}