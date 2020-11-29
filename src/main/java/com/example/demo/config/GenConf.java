package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 代码生成配置类
 * <br>Created by Admin on 2020/5/3.
 * <br>星期三 at 16:16.
 */
@Component
@ConfigurationProperties(prefix = "gencode")
@Data
public class GenConf {
    private String srcPath;//项目系统路径
    private String entityPkg;//实体类所在包
    private String daoPkg;//dao所在包
    private String sqlPath;//sql文件位置 默认即可
}
