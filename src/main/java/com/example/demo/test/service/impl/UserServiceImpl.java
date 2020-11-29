package com.example.demo.test.service.impl;

import com.example.demo.test.dao.UserDao;
import com.example.demo.test.entity.User;
import com.example.demo.test.service.UserService;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/11/29 14:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        List<User> select = userDao.sample(null);
        return select;
    }

    @Override
    public SQLManager getSQLManager() {
        return userDao.getSQLManager();
    }
}
