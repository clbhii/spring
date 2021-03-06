package com.cl.controller;

import com.cl.model.UserDO;
import com.cl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * by cl at 2020/6/25 0025
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAll")
    public String getAll() {
        List<UserDO> list = userService.list();
        System.out.println("list:" + list);
        return list.toString();
    }

    @RequestMapping("/insert")
    public String insert() {
        UserDO user = new UserDO();
        // 不设置id的话，会自动生成一个UUID
//        user.setId(new Date().getTime() + "");
        user.setUserName("aaa");
        user.setPassword("111");
        user.setEmail("111");
        boolean save = userService.save(user);
        return getAll();
    }
}
