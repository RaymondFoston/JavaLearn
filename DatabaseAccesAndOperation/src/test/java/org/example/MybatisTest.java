package org.example;

import com.mybatis.entity.Employee;
import com.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    private EmployeeMapper employeeMapper;
    private SqlSession sqlSession;
    @Before
    public void employeeMapper(){
        //使用Mybatis第一步: 获取sqlSessionFactory对象
        String resource = "mybatis-conf.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //sqlSession对象非线程安全，使用一次创建一次销毁一次
        sqlSession = sqlSessionFactory.openSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
    }
    @After
    public void finalAction(){
        sqlSession.close();
    }
    public void printEmployeeList(List<Employee> employees){
        for(Employee employee: employees){
            System.out.println(employee);
        }
    }

    @Test
    public void queryAction() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=查询用户=-=-=-=-=-=-=-=-=-=-=");
        //查询全部用户
        List<Employee> employeeList = employeeMapper.getEmployeeList();
        printEmployeeList(employeeList);
        System.out.println("================================");
        //根据id查询用户
        Employee employee = employeeMapper.getEmployeeByID(1);
        System.out.println(employee);
        System.out.println("================================");
        //根据姓名查询
        employeeList = employeeMapper.getEmpBylastNameLike("J");
        printEmployeeList(employeeList);
        System.out.println("================================");

    }
    @Test
    public void insertAction() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=添加用户=-=-=-=-=-=-=-=-=-=-=");
        //添加用户
        //通过employee对象添加
        Employee employee = new Employee();
        employee.setId(6);
        employee.setLastName("普京");
        employee.setGendor("male");
        employee.setAge(59);
        Boolean addEmployee = employeeMapper.addEmployeeCustomID(employee);
        sqlSession.commit();
        printEmployeeList(employeeMapper.getEmployeeList());
        System.out.println(addEmployee);
        System.out.println("================================");
        //通过map对象添加
        Map<String, Object> employeeMap = new HashMap<String, Object>();
        employeeMap.put("id", 7);
        employeeMap.put("lastName", "特朗普");
        employeeMap.put("gendor", "male");
        employeeMap.put("age", 46);
        Boolean addEmployeeMap = employeeMapper.addEmployeeMap(employeeMap);
        sqlSession.commit();
        printEmployeeList(employeeMapper.getEmployeeList());
        System.out.println(addEmployeeMap);
    }
    @Test
    public void updateAction() {
        //修改用户
        System.out.println("-=-=-=-=-=-=-=-=-=-=修改用户=-=-=-=-=-=-=-=-=-=-=");
        Employee employee = new Employee();
        employee.setId(6);
        employee.setLastName("尼古拉斯");
        employee.setGendor("男");
        Boolean updateEmployee = employeeMapper.updateEmployee(employee);
        System.out.println(updateEmployee);
        sqlSession.commit();
        printEmployeeList(employeeMapper.getEmployeeList());
        System.out.println(updateEmployee);

    }
    @Test
    public void deleteAction(){
        //删除用户
        System.out.println("-=-=-=-=-=-=-=-=-=-=删除用户=-=-=-=-=-=-=-=-=-=-=");
        Boolean deleteEmployeeBy6 = employeeMapper.deleteEmployeeById(6);
        Boolean deleteEmployeeBy7 = employeeMapper.deleteEmployeeById(7);
        sqlSession.commit();
        printEmployeeList(employeeMapper.getEmployeeList());
        System.out.println(deleteEmployeeBy6&deleteEmployeeBy7);

    }

    @Test
    public void addEmpGetetAutoIncrementID(){
        Employee employee = new Employee();
        employee.setLastName("Joy");
        employee.setGendor("male");
        employee.setAge(59);
        Boolean addEmployee = employeeMapper.addEmployeeAutoIncreID(employee);
        sqlSession.commit();
        printEmployeeList(employeeMapper.getEmployeeList());
        System.out.println(addEmployee);
    }
}
