package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.DataDictionary;
import com.xjtu.iqa.po.DataDictionaryExample;

public interface DataDictionaryMapper {
    int deleteByPrimaryKey(String DATADICTIONARYID);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);

    List<DataDictionary> selectByExample(DataDictionaryExample example);

    DataDictionary selectByPrimaryKey(String DATADICTIONARYID);

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);
}