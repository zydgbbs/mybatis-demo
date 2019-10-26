package com.zydgbbs.mybatis.test;

import com.zydgbbs.mybatis.dao.UserDao;
import com.zydgbbs.mybatis.dao.impl.UserDaoImpl;
import com.zydgbbs.mybatis.domain.User;

public class DaoTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUserById(30);
        System.out.println(user);
    }
}
