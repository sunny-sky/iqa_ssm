package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Advise;
import com.xjtu.iqa.pojo.AdviseExample;
import java.util.List;

public interface AdviseMapper {
    int deleteByPrimaryKey(String ADVISEID);

    int insert(Advise record);

    int insertSelective(Advise record);

    List<Advise> selectByExample(AdviseExample example);

    Advise selectByPrimaryKey(String ADVISEID);

    int updateByPrimaryKeySelective(Advise record);

    int updateByPrimaryKey(Advise record);
}