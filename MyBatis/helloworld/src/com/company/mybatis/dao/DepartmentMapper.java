package com.company.mybatis.dao;

import com.company.mybatis.bean.Department;

public interface DepartmentMapper {

    public Department getDeptById(Integer dept_id);
    public Department getDeptByidPlus(Integer dept_id);
    public Department getDeptByidPlusStep(Integer id);
}
