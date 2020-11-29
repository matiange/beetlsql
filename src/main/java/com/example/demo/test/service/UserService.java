package com.example.demo.test.service;

import com.example.demo.test.entity.User;
import org.beetl.sql.core.SQLManager;

import java.util.List;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/11/29 14:42
 */
public interface UserService {
    List<User> findAll();

    SQLManager getSQLManager();

}
