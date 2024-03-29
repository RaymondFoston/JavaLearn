package org.example;


import com.mybatis.entity.Department;
import com.mybatis.entity.Employee;
import com.mybatis.mapper.DepartmentMapper;
import com.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest2 {
    public SqlSession createSqlSession(){
        //加载mybatis全局配置文件
        String resource = "mybatis-conf.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession 实例,能直接执行已经映射的sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }

    /**
     * 测试增删改
     * 1. mybatis允许直接定义如下返回值：
     * Long, Integer, Boolean, void
     * 2.  sqlSessionFactory.openSession(); ====>我们 需要手动提交数据
     *       sqlSessionFactory.openSession(true)===> 自动提交数据
     */
    @Test
    public  void test(){
        SqlSession sqlSession = createSqlSession();
        try{
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            /*添加*/
            Employee employee = new Employee("Jecyka",0,null);
            employeeMapper.addEmp(employee);
            System.out.println(employee.getId());
            /*修改*/
//            Employee employee = new Employee(3,"John",1,"John@mail.com");
//            employeeMapper.updateEmp(employee);
            /*删除*/
//            Boolean delete=employeeMapper.deleteEmpById(4);
//            System.out.println(delete);
            //提交事务
//            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void test1(){
        SqlSession sqlSession = createSqlSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmpByIdAndLastName(2,"Lucy");

            System.out.println(employee);

        }finally {
            sqlSession.close();
        }
    }

    /**
     * 通过map类型的参数来进行查询
     */
    @Test
    public void test2(){
        SqlSession sqlSession = createSqlSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String,String> map = new HashMap<>();
            map.put("id","1");
            map.put("lastName", "Tom");
            Employee employee = employeeMapper.getEmpByMap(map);

            System.out.println(employee);

        }finally {
            sqlSession.close();
        }
    }


    /**
     * 返回一个集合类型
     */
    @Test
    public void test3(){
        SqlSession sqlSession = createSqlSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            //List
             List<Employee> list = employeeMapper.getEmpBylastNameLike("%e%");
            System.out.println(list);
             //一条记录Map
            Map<String, Object> map = employeeMapper.getEmpByIdReturnMap(1);
            System.out.println(map);
            //多条记录map
            Map<Integer, Employee> map1 = employeeMapper.getEmpByLastNameLikeReturnMap("%e%");
            System.out.println(map1);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test4(){
        SqlSession sqlSession = createSqlSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            //普通联合查询
//            Employee employee = employeeMapper.getEmpAndDept(1);
            //分步查询
            Employee employee = employeeMapper.getEmpAndDeptStep(1);
            System.out.println(employee);
            System.out.println(employee.getDepartment());
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 查询部门关联对象信息
     */
    @Test
    public void test5(){
        SqlSession sqlSession = createSqlSession();
        try{
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            Department departments;
//            departments = departmentMapper.getDeptByidPlus(1);
            departments = departmentMapper.getDeptByidPlusStep(1);
            System.out.println(departments.getDepartmentName());
//            System.out.println(departments.getEmployees());
        }finally {
            sqlSession.close();
        }
    }
    //discriminator
    @Test
    public void text6(){
        SqlSession sqlSession = createSqlSession();
        try{
            EmployeeMapper employeeMapper =sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmployeeByID(3);
            System.out.println(employee);
            System.out.println(employee.getDepartment());
        }finally {
            sqlSession.close();
        }
    }
}
