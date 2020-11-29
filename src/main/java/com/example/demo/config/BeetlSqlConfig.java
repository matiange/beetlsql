package com.example.demo.config;

import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description: beetl配置类
 * @date 2020/11/29 13:57
 */
@Configuration
public class BeetlSqlConfig {

    @Primary//sqlManager工厂(核心)
    @Bean(name = "sqlManagerFactoryBean")
    public SqlManagerFactoryBean getSqlManagerFactoryBean(
            @Qualifier("datasource") DataSource datasource) {
        SqlManagerFactoryBean factory = new SqlManagerFactoryBean();
        BeetlSqlDataSource source = new BeetlSqlDataSource();
        source.setMasterSource(datasource);//主数据源
        factory.setCs(source);
        //数据库类型
        factory.setDbStyle(new MySqlStyle());
        //debug模式 开发时使用 ：打印sql日志
        factory.setInterceptors(new Interceptor[]{new DebugInterceptor()});
        //命名转换方式
        factory.setNc(new UnderlinedNameConversion());
        return factory;
    }

    //数据源交给事务管理器管理事务
    @Bean(name = "txManager")//开启事务管理
    public DataSourceTransactionManager getDataSourceTransactionManager(
            @Qualifier("datasource") DataSource datasource) {
        DataSourceTransactionManager dstm = new DataSourceTransactionManager();
        dstm.setDataSource(datasource);
        return dstm;
    }

    //自定义beetlsql扫描包路径
    @Bean(name = "beetlSqlScannerConfigurer")
    public BeetlSqlScannerConfigurer getBeetlSqlScannerConfigurer() {
        BeetlSqlScannerConfigurer conf = new BeetlSqlScannerConfigurer();
        conf.setBasePackage("com.example");//扫描那些类可以自动注入
        conf.setSqlManagerFactoryBeanName("sqlManagerFactoryBean");
//        conf.setDaoSuffix();结构以xxx结尾
        return conf;
    }
}
