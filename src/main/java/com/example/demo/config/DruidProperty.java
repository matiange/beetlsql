package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description: 数据源属性类
 * @date 2020/11/29 13:59
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class DruidProperty {
    private String driverClassName;//连接驱动
    private String url;//url地址
    private String username;//用户名
    private String password;//密码
    private String filter;//filter过滤
    private Integer initialSize;//初始化连接大小
    private Integer minIdle;//最小空闲连接数
    private Integer maxActive;//最大连接数
}
