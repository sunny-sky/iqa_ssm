package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Configure;
import com.xjtu.iqa.pojo.ConfigureExample;
import java.util.List;

public interface ConfigureMapper {
    int deleteByPrimaryKey(String CONFIGUREID);

    int insert(Configure record);

    int insertSelective(Configure record);

    List<Configure> selectByExample(ConfigureExample example);

    Configure selectByPrimaryKey(String CONFIGUREID);

    int updateByPrimaryKeySelective(Configure record);

    int updateByPrimaryKey(Configure record);
}