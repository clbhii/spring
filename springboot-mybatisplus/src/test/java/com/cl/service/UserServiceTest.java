package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cl.DemoApplication;
import com.cl.model.UserDO;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * by cl at 2020/6/25 0025
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void save() {
        UserDO userDO = new UserDO();
        userDO.setUserName("cl111");
        userDO.setPassword("123456");
        userDO.setEmail("test@163.com");
        userService.save(userDO);
        System.out.println(userDO.getId());
    }
    @Test
    public void get() {
        userService.getById(2);
    }

    @Test
    public void update() {
        UserDO userDO = userService.getById(8);
        userDO.setPassword("12345678");
        userDO.setEmail(null);
        userDO.setDateUpdate(new Date());
        userService.updateById(userDO);
    }
    @Test
    public void delete() {
        userService.removeById(9);
    }
    @Test
    public void selectByUsernameAndPassword() {

        UserDO userDO = userService.selectByUserNameAndPassword("cl111", "123456");
        System.out.println(userDO.getEmail());
        List<UserDO> list1 = userService.list(new QueryWrapper<UserDO>().lambda().eq(UserDO::getUserName, "cl111"));
        List<UserDO> list2 = userService.list(new QueryWrapper<UserDO>().lambda().nested(i -> i.eq(UserDO::getUserName, "cl111"))
                .and(i->i.eq(UserDO::getPassword, "123456")));
    }


    @Test
    public void page() {
        Page<UserDO> page = new Page<>();
        page.setCurrent(2);
        page.setSize(5L);
        IPage<UserDO> userDOIPage = userService.selectPageVo(page);
        System.out.println(userDOIPage.toString());
    }
    @Test
    public void insertBatch() {
        UserDO userDO = new UserDO();
        userDO.setUserName("cl111");
        userDO.setPassword("123456");
        userDO.setEmail("test@163.com");
        UserDO userDO1 = new UserDO();
        userDO1.setUserName("cl111");
        userDO1.setPassword("123456");
        userDO1.setEmail("test@163.com");
        List<UserDO> list = new ArrayList<>();
        list.add(userDO);
        list.add(userDO1);
        userService.insertBatch(list);
    }
}
