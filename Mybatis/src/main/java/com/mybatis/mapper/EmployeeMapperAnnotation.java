package com.mybatis.mapper;


import com.mybatis.entity.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {


    @Select("select * from employee where id = #{id}")
    public Employee getEmployeeByID(Integer id);
}
