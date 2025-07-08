package org.example;


import com.mybatis.entity.Employee;
import com.mybatis.mapper.EmployeeMapper;
import com.mybatis.mapper.EmployeeMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest1 {

    private SqlSession sqlSession; //不能这样使用，每次使用都应该创建新的对象
    //Constructor
    //构造方法
    public MybatisTest1() {
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
        sqlSession = sqlSessionFactory.openSession();
        System.out.println("Constructor is invoked~");

    }


    @Test
    public void test1()  {
        //获取sqlSession对象
        SqlSession  openSession =  sqlSession;
        /**
        指向配置文件
         */
        //参数为命名空间+selectId,其中命名空间自定义
        Employee employee = openSession.selectOne("com.company.mybatis.mapper.EmployeeMapper.getEmployeeByID","1");
        System.out.println(employee);
        openSession.close();

    }



    @Test
    public void test2(){
        //获取sqlSesion对象
        SqlSession  openSession =  sqlSession;
        /**
         * 指向Mapper接口文件（此时映射文件与此Mapper绑定）
         */
        //获取接口的实现类对象,获取的对象类型为代理对象，执行增删改查的方法
        EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.getEmployeeByID(1);
        System.out.println(employeeMapper.getClass());
        System.out.println(employee.toString());
    }

    @Test
    public void test3(){
        //获取sqlSesion对象
        SqlSession  openSession =  sqlSession;
        //获取接口的实现类对象,获取的对象类型为代理对象，执行增删改查的方法
        EmployeeMapperAnnotation employeeMapper =
                openSession.getMapper(EmployeeMapperAnnotation.class);
        Employee employee = employeeMapper.getEmployeeByID(1);
        System.out.println(employeeMapper.getClass());
        System.out.println(employee.toString());
    }


    @Override
    protected void finalize(){
        System.out.println("in finalize");
    }
}


