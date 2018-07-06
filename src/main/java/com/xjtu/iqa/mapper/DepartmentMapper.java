package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Department;
import com.xjtu.iqa.po.DepartmentExample;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String DEPARTMENTID);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(String DEPARTMENTID);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}