package com.cl.security.core.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {


    @RequestMapping("/loginPage")
    public String login() {
        return "login_page";

    }
    @RequestMapping("/index")
    @ResponseBody
    public Object index() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}