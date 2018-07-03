package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.BasicConfigure;
import com.xjtu.iqa.pojo.BasicConfigureExample;
import java.util.List;

public interface BasicConfigureMapper {
    int deleteByPrimaryKey(String BASICCONFIGURE);

    int insert(BasicConfigure record);

    int insertSelective(BasicConfigure record);

    List<BasicConfigure> selectByExample(BasicConfigureExample example);

    BasicConfigure selectByPrimaryKey(String BASICCONFIGURE);

    int updateByPrimaryKeySelective(BasicConfigure record);

    int updateByPrimaryKey(BasicConfigure record);
}