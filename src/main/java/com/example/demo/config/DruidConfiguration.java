package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description: 创建数据源
 * @date 2020/11/29 14:14
 */
@Configuration
public class DruidConfiguration {

    @Resource
    private DruidProperty druidProperty;


    @Bean(name = "datasource")//数据库配置bean
    public DataSource getDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(druidProperty.getDriverClassName());
        dataSource.setUrl(druidProperty.getUrl());
        dataSource.setUsername(druidProperty.getUsername());
        dataSource.setPassword(druidProperty.getPassword());
        dataSource.setFilters(druidProperty.getFilter());
        dataSource.setInitialSize(druidProperty.getInitialSize());
        dataSource.setMinIdle(druidProperty.getMinIdle());
        dataSource.setMaxActive(druidProperty.getMaxActive());
        return dataSource;
    }
}
