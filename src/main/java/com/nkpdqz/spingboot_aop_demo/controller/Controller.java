package com.nkpdqz.spingboot_aop_demo.controller;

import com.nkpdqz.spingboot_aop_demo.DAO.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
