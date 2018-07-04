package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Soft;
import com.xjtu.iqa.pojo.SoftExample;
import com.xjtu.iqa.pojo.SoftWithBLOBs;
import java.util.List;

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