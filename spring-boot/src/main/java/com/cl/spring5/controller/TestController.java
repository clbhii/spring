package com.cl.spring5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cl.spring5.model.User;

@RestController
@RequestMapping("/springboot")
public class TestController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello world";
	}

	@Autowired
	User user;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String sayWorld(@PathVariable("name") String name) {
		System.out.println("userName:" + user.getCustomerName() + ":" + user.getAge() + ":" + user.getAddress());
		return "Hello " + name;
	}

}
