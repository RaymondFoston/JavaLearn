package org.example;

import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class JDBCTest {
    /**
     * Create the test case
     *
     */
    @Test
    public void testApp()
    {
        assertTrue( true );
    }

    /**
     * JDBDC使用
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void JDBCDemo1() throws ClassNotFoundException, SQLException {
        //1.导入jar包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://10.211.55.18:3306/jdbc_tutorial", "admin", "123456");
        //4.定义SQL语句
        String sql = "select count(*) from employee;";
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

    /**
     * JDBC使用优化版本
     */
    @Test
    public void JDBCDemo2() {
        //1.导入jar包
        Connection connection =null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //2.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3.获取数据库连接对象
            connection = DriverManager.getConnection("jdbc:mysql://10.211.55.18:3306/jdbc_tutorial", "admin", "123456");
            //4.定义SQL语句
            String sql = "select * from employee;";
            //5.获取执行sql语句的对象
            statement = connection.createStatement();
            //6.执行sql并返回结果
            resultSet = statement.executeQuery(sql);
            //7.处理结果
            System.out.println(resultSet);
            while(resultSet.next()){
                System.out.println(resultSet.getString(2));
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

}
