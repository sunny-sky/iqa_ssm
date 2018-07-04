package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Patch;
import com.xjtu.iqa.pojo.PatchExample;
import com.xjtu.iqa.pojo.PatchWithBLOBs;
import java.util.List;

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