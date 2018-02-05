package org.FIR.dao;

import org.FIR.entity.FIRGameRecord;
import org.FIR.entity.FIRGameUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author tianyi
 * @date 2017-12-31 16:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class FIRGameUserDaoTest {
    @Resource
    private FIRGameUserDao firGameUserDao;

    @Test
    public void addUser() throws Exception {
        firGameUserDao.addUser("daishan1","1234");
    }

    @Test
    public void queryById() throws Exception {
        FIRGameUser firGameUser=firGameUserDao.queryById(1);
        System.out.println(firGameUser.getUserPhone());
    }

    @Test
    public void queryAll() throws Exception {
        List<FIRGameUser> firGameUserList=firGameUserDao.queryAll(0,20);
        for (FIRGameUser firGameUser:firGameUserList) {
            System.out.println(firGameUser.getUserName());
        }
    }

    @Test
    public void getId() throws Exception {
        System.out.println(firGameUserDao.getId("daishan1"));
    }

    @Test
    public void getPassword() throws Exception {
        System.out.println(firGameUserDao.getPassword("daishan1"));
    }

}