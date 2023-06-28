package com.itheima.test;

import com.itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @BelongsProject: SpringNew
 * @BelongsPackage: com.itheima.test
 * @Author: ASUS
 * @CreateTime: 2023-06-27  10:12
 * @Description: TODO
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    /*
     * @description:更新操作
     * @author:  HZP
     * @date: 2023/6/27 10:14
     * @param: []
     * @return: void
     **/
    public void UpdateTest(){
        jdbcTemplate.update("update account set money=? where name=?",1000,"tom");
    }


    @Test
    /*
     * @description:删除操作
     * @author:  HZP
     * @date: 2023/6/27 10:18
     * @param: []
     * @return: void
     **/
    public void deleteTest(){
        jdbcTemplate.update("delete account from account where name=?","tom");
    }
    @Test
    /*
     * @description:查询多条数据
     * @author:  HZP
     * @date: 2023/6/27 10:23
     * @param: []
     * @return: void
     **/
    public void queryOtherTest(){
        List<Account> query = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(query);
    }

    @Test
    /*
     * @description:查询单条数据
     * @author:  HZP
     * @date: 2023/6/27 10:25
     * @param: []
     * @return: void
     **/
    public void queryOneTest(){
        Account tom = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "jack");
        System.out.println(tom);
    }
}
