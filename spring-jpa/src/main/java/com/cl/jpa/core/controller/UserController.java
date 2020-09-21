package com.cl.jpa.core.controller;

import com.cl.jpa.core.common.ErrorCode;
import com.cl.jpa.core.common.Result;
import com.cl.jpa.core.common.ResultSupport;
import com.cl.jpa.core.dao.UserRepository;
import com.cl.jpa.core.entity.User;
import com.cl.jpa.core.service.dto.UserDTO;
import com.cl.jpa.core.service.dto.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @PersistenceContext
    EntityManager entityManager;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @RequestMapping("/getAllUser")
//    public Result<?> getAllUser(){
//        Result result=userService.getAllUser();
//        ModelAndView mv=new ModelAndView();
//        mv.addObject("userList",result.getData());
//        mv.setViewName("index.html");
//        return mv;
//    }

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public Result<Page<User>> page(User entity0) {
        Pageable pageable = PageRequest.of(0, 10);
        Page<User> all = userRepository.findAll(
                new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                list.add(cb.equal(root.get("username"), "cl"));
                list.add(cb.equal(root.get("password"), "123"));
                //此时条件之间是没有任何关系的。
                Predicate[] arr = new Predicate[list.size()];
                return cb.and(list.toArray(arr));
            }
        },
                pageable);
        all.getContent().forEach(user -> {
            user.setDescriptionList(null);
            user.setDescription(null);
            user.setDescription2List(null);
        });
        return new ResultSupport<>(true, all, ErrorCode.SUCCESS);
    }


    @RequestMapping(value = "page1", method = RequestMethod.GET)
    public Result<List<User>> page1(User entity0) {
        Pageable pageable = PageRequest.of(0, 10);
        Query query = entityManager.createQuery("FROM  User");
        query.setFirstResult((int)pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        List resultList = query.getResultList();
        return new ResultSupport<>(true, resultList, ErrorCode.SUCCESS);
    }

    /**
     * 自定义
     * @return
     */
    @RequestMapping("customerList")
    public Result<List<UserInterface>> customerList() {
        return new ResultSupport<>(true, userRepository.findAllById(1), ErrorCode.SUCCESS);
    }
    /**
     * 自定义
     * @return
     */
    @RequestMapping("customer1")
    public Result<List<UserDTO>> customer1() {
        return new ResultSupport(true, userRepository.getById(1), ErrorCode.SUCCESS);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Result<User> get(@PathVariable("id") Integer id) {
        return new ResultSupport<>(true, userRepository.findById(id).get(), ErrorCode.SUCCESS);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public User save(User entity) {
//        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userRepository.saveAndFlush(entity);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
         userRepository.deleteById(id);
    }
}