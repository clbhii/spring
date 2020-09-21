package com.cl.jpa.core.service;

import com.cl.jpa.core.CoreApplication;
import com.cl.jpa.core.dao.UserRepository;
import com.cl.jpa.core.entity.Description;
import com.cl.jpa.core.entity.User;
import com.cl.jpa.core.service.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Copyright © 2018年 chilunyc.com All rights reserved.
 */

/**
 * CascadeType 只针对级联对象
 * https://www.jianshu.com/p/e8caafce5445
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
public class CascadeTypeTest {
    @Autowired
    private UserRepository userRepository;

    /**
     * 没有CascadeType， 只建立关联，不进行级联操作
     */
    @Test
    public void cascadeType(){
//        User user = new User();
//        user.setUsername("cl1");
//        user.setPassword("123456");
//
////        Description description = new Description();
////        description.setDescription("desc_11");
////        user.setDescription(description);
//        userRepository.save(user);
        User user1 = userRepository.getOne(2);
        System.out.println(user1.getDescription().getDescription());
        user1.getDescription().setDescription("desc_22");
        userRepository.save(user1);

    }

    /**
     * 只级联新增，不级联其他
     */
    @Test
    public void cascadeTypePERSIST(){

        User user = new User();
        user.setUsername("cl1");
        user.setPassword("123456");

        Description description = new Description();
        description.setDescription("desc_11");
        user.setDescription(description);
        userRepository.save(user);
//
//        User user1 = userRepository.getOne(2);
//        user1.getDescription().setDescription("desc_22");
//        userRepository.save(user1);


    }

    /**
     * 只级联更新，不级联其他
     */
    @Test
    public void cascadeTypeMERGE(){
        User user1 = userRepository.getOne(2);
        user1.getDescription().setDescription("desc_22");
        userRepository.save(user1);
    }
}
