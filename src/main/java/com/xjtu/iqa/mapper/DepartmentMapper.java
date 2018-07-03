package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Department;
import com.xjtu.iqa.pojo.DepartmentExample;
import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String DEPARTMENTID);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(String DEPARTMENTID);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}