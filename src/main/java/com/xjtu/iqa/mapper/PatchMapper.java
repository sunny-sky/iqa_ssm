package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Patch;
import com.xjtu.iqa.po.PatchExample;
import com.xjtu.iqa.po.PatchWithBLOBs;

public interface PatchMapper {
    int deleteByPrimaryKey(String CONFIGUREID);

    int insert(PatchWithBLOBs record);

    int insertSelective(PatchWithBLOBs record);

    List<PatchWithBLOBs> selectByExampleWithBLOBs(PatchExample example);

    List<Patch> selectByExample(PatchExample example);

    PatchWithBLOBs selectByPrimaryKey(String CONFIGUREID);

    int updateByPrimaryKeySelective(PatchWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PatchWithBLOBs record);

    int updateByPrimaryKey(Patch record);
}