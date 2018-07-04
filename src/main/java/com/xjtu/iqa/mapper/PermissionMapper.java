package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Permission;
import com.xjtu.iqa.pojo.PermissionExample;
import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(String PERMISSIONID);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(String PERMISSIONID);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}