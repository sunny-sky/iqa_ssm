package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Agree;
import com.xjtu.iqa.pojo.AgreeExample;
import java.util.List;

public interface AgreeMapper {
    int deleteByPrimaryKey(String AGREEID);

    int insert(Agree record);

    int insertSelective(Agree record);

    List<Agree> selectByExample(AgreeExample example);

    Agree selectByPrimaryKey(String AGREEID);

    int updateByPrimaryKeySelective(Agree record);

    int updateByPrimaryKey(Agree record);
}