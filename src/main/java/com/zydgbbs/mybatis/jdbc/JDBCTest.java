package com.zydgbbs.mybatis.jdbc;

import java.sql.*;

/**
 * 加载驱动
 * 创建连接
 * 设置SQL语句
 * 设置参数
 * 执行SQL，得到esultSet
 * 遍历ResultSet，输出结果
 * 释放资源
 */
public class JDBCTest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false",
                    "root","root");
            String sql = "select * from user where username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"王五");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("id")+" "+resultSet.getString("username"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet!=null) {
                    resultSet.close();
                }
                if (preparedStatement!=null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException e){
                    e.printStackTrace();
            }
        }
    }
}
