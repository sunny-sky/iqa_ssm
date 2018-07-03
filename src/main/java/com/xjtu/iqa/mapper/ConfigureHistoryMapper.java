package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.ConfigureHistory;
import com.xjtu.iqa.pojo.ConfigureHistoryExample;
import java.util.List;

public interface ConfigureHistoryMapper {
    int deleteByPrimaryKey(String CONFIGUREHISTORYID);

    int insert(ConfigureHistory record);

    int insertSelective(ConfigureHistory record);

    List<ConfigureHistory> selectByExampleWithBLOBs(ConfigureHistoryExample example);

    List<ConfigureHistory> selectByExample(ConfigureHistoryExample example);

    ConfigureHistory selectByPrimaryKey(String CONFIGUREHISTORYID);

    int updateByPrimaryKeySelective(ConfigureHistory record);

    int updateByPrimaryKeyWithBLOBs(ConfigureHistory record);

    int updateByPrimaryKey(ConfigureHistory record);
}