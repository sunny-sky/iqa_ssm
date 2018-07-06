package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Soft;
import com.xjtu.iqa.po.SoftExample;
import com.xjtu.iqa.po.SoftWithBLOBs;

public interface SoftMapper {
    int deleteByPrimaryKey(String CONFIGUREID);

    int insert(SoftWithBLOBs record);

    int insertSelective(SoftWithBLOBs record);

    List<SoftWithBLOBs> selectByExampleWithBLOBs(SoftExample example);

    List<Soft> selectByExample(SoftExample example);

    SoftWithBLOBs selectByPrimaryKey(String CONFIGUREID);

    int updateByPrimaryKeySelective(SoftWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SoftWithBLOBs record);

    int updateByPrimaryKey(Soft record);
}