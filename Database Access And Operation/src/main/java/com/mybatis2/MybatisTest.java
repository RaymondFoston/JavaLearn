package com.mybatis2;


import com.mybatis2.bean.Employee;
import com.mybatis2.dao.EmployeeMapper;
import com.mybatis2.dao.EmployeeMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    /**
     * 1. 根据xml配置文件(全局配置文件)创建一个sqlSessionFactory对象。
     *     有数据源等一些有效配置信息
     * 2. sql映射文件，配置了每一个sql，以及sql的封装规则等
     * 3. 将sql映射文件注册到全局配置文件中
     * 4 . 写代码
     *      1).根据全局配置得到SqlSessionFactory
     *      2).根据sqlSessionFactory,获取到sqlSession对象，来进行增删改查。
     *          一个sqlSession代表和数据库的一次会话，用完关闭
     *      3).使用sql的唯一标识来告诉MyBatis执行那个SQL,sql都是保存在sql‘映射文件中
     * @throws IOException
     */
    /**
     * 1. 接口式编程
     *      原生： Dao ====> DaoImp
     *      Now:   Mapper ===> ***Mapper.xml
     *  2. sqlSession代表和数据库的一次会话，用完需要关闭
     *  3. SqlSession和connection一样都是非线程安全，每次使用都应该去创建新的 对象
     *  4. mapper接口没有实现类，但mybatis会为这个接口创建代理类对象（将接口与xml配置文件绑定）
     *  5.两个重要的配置文件：
     *      * mybatis的全局配置文件：数据库连接池信息，事务管理器信息
     *      * sql映射文件
     */

    private SqlSession sqlSession; //不能这样使用，每次使用都应该创建新的对象
    //Constructor
    public  MybatisTest() {
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
        Employee employee = openSession.selectOne("com.company.mybatis.dao.EmployeeMapper.getEmployeeByID","1");
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


