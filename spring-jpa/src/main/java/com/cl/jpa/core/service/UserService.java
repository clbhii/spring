package com.cl.jpa.core.service;

import com.cl.jpa.core.dao.UserRepository;
import com.cl.jpa.core.service.dto.UserInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2018年 chilunyc.com All rights reserved.
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Page<UserInterface> page(Pageable pageable){
//        Page<UserDTO> all = userRepository.findAll(
//                new Specification<User>() {
//                    @Override
//                    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
//                        List<Predicate> list = new ArrayList<>();
//                        list.add(cb.equal(root.get("username"), "cl"));
//                        list.add(cb.equal(root.get("password"), "123"));
//                        //此时条件之间是没有任何关系的。
//                        Predicate[] arr = new Predicate[list.size()];
//                        return cb.and(list.toArray(arr));
//                    }
//                },
//                pageable);
     return  null;
    }
}
