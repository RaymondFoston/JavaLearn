package com.mybatis.mapper;


import com.mybatis.entity.Employee;
import com.mybatis.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    //查询
    public List<Employee> getEmployeeList();
    public Employee getEmployeeByID(Integer id);
    public Employee getEmpByIdAndLastName(@Param("id") Integer id,@Param("lastName") String lastName);
    public Employee getEmpByMap(Map<String,String> map);
    //返回一个List
    public List<Employee> getEmpBylastNameLike(String lastName);
    //返回一条记录的Map
    public Map<String,Object> getEmpByIdReturnMap(Integer id);
    //返回多条记录封装的map，map={id: employee}
    @MapKey("id")//告诉Mybatis封装map时要作为key使用的属性
    public Map<Integer, Employee> getEmpByLastNameLikeReturnMap (String lastName);
    //有外键
    public Employee getEmpAndDept(Integer id);
    public Employee getEmpAndDeptStep(Integer id);
    public List<Employee> getEmpsByDeptId(Integer deptId);

    //添加
    public Boolean addEmployeeCustomID(Employee employee);
    public Boolean addEmployeeAutoIncreID(Employee employee);
    public Boolean addEmployeeMap(Map<String, Object> employeeMap);


    //修改
    public Boolean updateEmployee(Employee employee);

    //删除
    public Boolean deleteEmployeeById(Integer id);


}
