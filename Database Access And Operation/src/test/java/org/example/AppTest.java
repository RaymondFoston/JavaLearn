package org.example;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Create the test case
     *
     */
    @Test
    public void testApp()
    {
        assertTrue( true );
    }

    @Test
    public void JDBCDemo1() throws ClassNotFoundException, SQLException {
        //1.导入jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm", "root", "78d5fdada80e");
        //4.定义SQL语句
        String sql = "select count(*) from customer;";
        //5.获取执行sql语句的对象
        Statement statement = connection.createStatement();
        //6.执行sql并返回结果
        ResultSet resultSet = statement.executeQuery(sql);
        //7.处理结果
        System.out.println(resultSet);
        //8.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void JDBCDemo2() {
        //1.导入jar包
        Connection connection =null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.获取数据库连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm", "root", "78d5fdada80e");
            //4.定义SQL语句
            String sql = "select * from customer;";
            //5.获取执行sql语句的对象
            statement = connection.createStatement();
            //6.执行sql并返回结果
            resultSet = statement.executeQuery(sql);
            //7.处理结果
            System.out.println(resultSet);
            while(resultSet.next()){
                System.out.println(resultSet.getString(6));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            //8.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection !=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Test
    public void test(){
        //使用Mybatis第一步: 获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //查询全部用户
        System.out.println("-=-=-=-=-=-=-=-=-=-=查询全部用户=-=-=-=-=-=-=-=-=-=-=");
        List<User> userList = userMapper.getUserList();
        for(User user : userList){
            System.out.println(user);
        }
        //根据id查询用户
        System.out.println("-=-=-=-=-=-=-=-=-=-=根据id查询用户=-=-=-=-=-=-=-=-=-=-=");
        User user = userMapper.getUserById(1);
        System.out.println(user);
        user = userMapper.getUserLikeName("李");
        System.out.println(user);
        //添加用户
        System.out.println("-=-=-=-=-=-=-=-=-=-=添加用户=-=-=-=-=-=-=-=-=-=-=");
        user.setId(4);
        user.setName("张麻子");
        user.setPwd("256621");
        int addUser = userMapper.addUser(user);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id", 5);
        map.put("name", "特朗普");
        map.put("pwd","asdjf01932");
        userMapper.addUser2(map);
        sqlSession.commit();
        System.out.println(addUser);
        userMapper.getUserList();
        //修改用户
        System.out.println("-=-=-=-=-=-=-=-=-=-=修改用户=-=-=-=-=-=-=-=-=-=-=");
        user.setId(5);
        user.setName("尼古拉斯");
        int updateUser = userMapper.updateUser(user);
        System.out.println(updateUser);
        sqlSession.commit();
        userMapper.getUserList();
        //删除用户
        System.out.println("-=-=-=-=-=-=-=-=-=-=删除用户=-=-=-=-=-=-=-=-=-=-=");
        int deleteUser = userMapper.deleteUser(4);
        userMapper.deleteUser(5);
        sqlSession.commit();
        userMapper.getUserList();
        sqlSession.close();

    }

}
