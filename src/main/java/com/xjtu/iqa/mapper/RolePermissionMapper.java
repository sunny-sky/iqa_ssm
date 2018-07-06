package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.RolePermission;
import com.xjtu.iqa.po.RolePermissionExample;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(String ROLEPERMISSIONID);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByExample(RolePermissionExample example);

    RolePermission selectByPrimaryKey(String ROLEPERMISSIONID);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}