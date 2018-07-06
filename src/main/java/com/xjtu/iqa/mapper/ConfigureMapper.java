package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Configure;
import com.xjtu.iqa.po.ConfigureExample;

public interface ConfigureMapper {
    int deleteByPrimaryKey(String CONFIGUREID);

    int insert(Configure record);

    int insertSelective(Configure record);

    List<Configure> selectByExample(ConfigureExample example);

    Configure selectByPrimaryKey(String CONFIGUREID);

    int updateByPrimaryKeySelective(Configure record);

    int updateByPrimaryKey(Configure record);
}