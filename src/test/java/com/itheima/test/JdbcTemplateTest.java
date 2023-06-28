package com.itheima.test;

import com.itheima.domain.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.PropertyVetoException;
import java.util.List;

import static com.alibaba.druid.sql.ast.SQLPartitionValue.Operator.List;

/**
 * @BelongsProject: SpringNew
 * @BelongsPackage: com.itheima.test
 * @Author: ASUS
 * @CreateTime: 2023-06-27  09:00
 * @Description: TODO
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
     * @description:老方法
     * @author:  HZP
     * @date: 2023/6/27 9:03
     * @param:
     * @return:
     **/
    @Test
    public void test1(){
        //创建数据源对象
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
            dataSource.setUser("root");
            dataSource.setPassword("1234");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象  知道数据库在哪里
        jdbcTemplate.setDataSource(dataSource);
        //执行操作
       // jdbcTemplate.update("insert into account values(?,?)","tom",5000);
    }

    @Test
    public void test2(){
        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //JdbcTemplate bean = app.getBean(JdbcTemplate.class);
        jdbcTemplate.update("insert into account values('tom',5000)");
    }


}
