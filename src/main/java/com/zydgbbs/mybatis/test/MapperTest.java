package com.zydgbbs.mybatis.test;

import com.zydgbbs.mybatis.domain.User;
import com.zydgbbs.mybatis.mapper.UserMapper;
import com.zydgbbs.mybatis.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class MapperTest {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(30);
        sqlSession.close();
        System.out.println(user);
    }
}
