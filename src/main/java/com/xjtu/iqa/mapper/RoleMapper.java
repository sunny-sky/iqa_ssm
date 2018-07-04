package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Role;
import com.xjtu.iqa.pojo.RoleExample;
import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(String ROLEID);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(String ROLEID);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}