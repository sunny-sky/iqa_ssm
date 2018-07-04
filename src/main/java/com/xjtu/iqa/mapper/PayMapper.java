package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Pay;
import com.xjtu.iqa.pojo.PayExample;
import java.util.List;

public interface PayMapper {
    int deleteByPrimaryKey(String PAYID);

    int insert(Pay record);

    int insertSelective(Pay record);

    List<Pay> selectByExample(PayExample example);

    Pay selectByPrimaryKey(String PAYID);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);
}