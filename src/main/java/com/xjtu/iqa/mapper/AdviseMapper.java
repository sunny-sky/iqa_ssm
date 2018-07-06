package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Advise;
import com.xjtu.iqa.po.AdviseExample;

public interface AdviseMapper {
    int deleteByPrimaryKey(String ADVISEID);

    int insert(Advise record);

    int insertSelective(Advise record);

    List<Advise> selectByExample(AdviseExample example);

    Advise selectByPrimaryKey(String ADVISEID);

    int updateByPrimaryKeySelective(Advise record);

    int updateByPrimaryKey(Advise record);
}