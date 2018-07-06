package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Pay;
import com.xjtu.iqa.po.PayExample;

public interface PayMapper {
    int deleteByPrimaryKey(String PAYID);

    int insert(Pay record);

    int insertSelective(Pay record);

    List<Pay> selectByExample(PayExample example);

    Pay selectByPrimaryKey(String PAYID);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);
}