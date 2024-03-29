package com.mybatis2.dao;


import com.mybatis2.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {


    @Select("select * from employee where id = #{id}")
    public Employee getEmployeeByID(Integer id);
}
