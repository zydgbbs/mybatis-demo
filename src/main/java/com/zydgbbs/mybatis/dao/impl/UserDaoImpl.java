package com.zydgbbs.mybatis.dao.impl;

import com.zydgbbs.mybatis.dao.UserDao;
import com.zydgbbs.mybatis.domain.User;
import com.zydgbbs.mybatis.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao{
    @Override
    public User getUserById(Integer id) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        User user = sqlSession.selectOne("user.getUserById",1);
        System.out.println(user);
        sqlSession.close();
        return user;
    }
}
