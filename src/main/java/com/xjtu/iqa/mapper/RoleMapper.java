package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Role;
import com.xjtu.iqa.po.RoleExample;

public interface RoleMapper {
    int deleteByPrimaryKey(String ROLEID);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(String ROLEID);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}