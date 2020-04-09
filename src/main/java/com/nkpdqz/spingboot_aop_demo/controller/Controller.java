package com.nkpdqz.spingboot_aop_demo.controller;

import com.nkpdqz.spingboot_aop_demo.DAO.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
@RequestMapping("/aop/")
public class Controller {

    @GetMapping("user")
    public User testAop(){
        User user = new User();
        user.setId(1);
        user.setName("nkpdqz");
        return user;
    }

    @GetMapping("say")
    public User testInterceptor(){
        System.out.println("this!");
        return new User(22,"tony");
    }

    @GetMapping("login")
    public String login(){
        return "token";
    }
}
