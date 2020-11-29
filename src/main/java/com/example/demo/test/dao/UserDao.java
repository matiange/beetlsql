package com.example.demo.test.dao;
import org.beetl.sql.core.annotatoin.*;
import org.beetl.sql.core.db.KeyHolder;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import com.example.demo.test.entity.*;

import java.util.List;

/*
* 
* gen by beetlsql mapper 2020-11-29
*/
public interface UserDao extends BaseMapper<User> {

    List<User> select(User user);

    List<User> sample(User user);
}
