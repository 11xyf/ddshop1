package com.xyf.ddshop.dao;

import com.xyf.ddshop.pojo.po.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: Administrator
 * Date: 2017/11/4
 * Time: 14:45
 * Version:V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao-test.xml"})
public class TbUserMapperTest {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Test
    public void testSelectByPrimaryKey() throws Exception {

        TbUser tbUser = tbUserMapper.selectByPrimaryKey(5L);
        System.out.println(tbUser.getUsername());
    }

}