package com.zydgbbs.mybatis.test;

import com.zydgbbs.mybatis.domain.User;
import com.zydgbbs.mybatis.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    @Test
    public void testGetUserById() throws Exception{
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        User user = sqlSession.selectOne("user.getUserById",1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetUserByUserName() throws Exception{
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        List<User> userList = sqlSession.selectList("user.getUserByName","张");
        for (User user:userList
             ) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setAddress("703");
        user.setUsername("梁亚飞3");
        user.setBirthday(new Date());
        user.setSex("男");
        //SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession(true);//自动提交
        //数据库影响的行数
        int result = sqlSession.insert("user.insertUser",user);
        //sqlSession.commit();
        System.out.println(user);
        System.out.println(result);

    }

    @Test
    public void testInsertUserUUID(){
        User user = new User();
        user.setAddress("703");
        user.setUsername("梁亚飞5");
        user.setBirthday(new Date());
        user.setSex("男");
        //SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession(true);//自动提交
        //数据库影响的行数
        int result = sqlSession.insert("user.insertUserUUID",user);
        //sqlSession.commit();
        System.out.println(user);
        System.out.println(result);

    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(30);
        user.setUsername("彰武");
        //SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession(true);//自动提交
        //数据库影响的行数
        int result = sqlSession.update("user.updateUser",user);
        //sqlSession.commit();
        System.out.println(user);
        System.out.println(result);
    }

    @Test
    public void testDeleteUser(){
        //SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession(true);//自动提交
        //数据库影响的行数
        int result = sqlSession.delete("user.deleteUser",30);
        //sqlSession.commit();
        System.out.println(result);
    }

}
