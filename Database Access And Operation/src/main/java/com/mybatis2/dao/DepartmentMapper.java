package com.mybatis2.dao;


import com.mybatis2.bean.Department;

public interface DepartmentMapper {

    public Department getDeptById(Integer dept_id);
    public Department getDeptByidPlus(Integer dept_id);
    public Department getDeptByidPlusStep(Integer id);
}
