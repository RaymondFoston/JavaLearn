package com.company.mybatis.dao;

import com.company.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {


    @Select("select * from employee where id = #{id}")
    public Employee getEmployeeByID(Integer id);
}
