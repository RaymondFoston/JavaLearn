package com.mybatis.mapper;


import com.mybatis.entity.Department;

public interface DepartmentMapper {

    public Department getDeptById(Integer dept_id);
    public Department getDeptByidPlus(Integer dept_id);
    public Department getDeptByidPlusStep(Integer id);
}
