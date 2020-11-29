package com.example.demo.test.controller;

import com.example.demo.config.GenConf;
import com.example.demo.test.entity.User;
import com.example.demo.test.service.UserService;
import org.beetl.sql.ext.gen.GenConfig;
import org.beetl.sql.ext.gen.MapperCodeGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description: beetlsql用户查询
 * @date 2020/11/29 14:40
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private GenConf genConf;//路径配置

    /**
     * @Description: ${description}
     * @author MaTianGe
     * @params
     * @return
     * @date 14:42 2020/11/29
     * @version 0.1
     */
    @RequestMapping("findAll")
    public List<User> findAll(){
        return userService.findAll();
    }



    /**
     * 单表的自动生成代码
     *
     * @param tableName 表名
     * @return 返回tables页面
     * @throws Exception 抛出异常
     */
    @RequestMapping(value = "genCode", method = RequestMethod.POST)
    public String genCode(String tableName) throws Exception {
        GenConfig config = new GenConfig();
        MapperCodeGen mapperCodeGen = new MapperCodeGen(genConf.getDaoPkg());
        config.codeGens.add(mapperCodeGen);
        userService.getSQLManager().genPojoCode(tableName, genConf.getEntityPkg(), config);//生成实体类代码
        userService.getSQLManager().genSQLFile(tableName,config);
        return "OK";
    }
}
