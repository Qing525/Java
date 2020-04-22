package com.ljq.aop01.controller;

import com.ljq.aop01.jdkProxy.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : lijq
 * @date : 2020/4/5 13:56
 */
@RestController
public class TestAopController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        userService.add("xx");
        return "xx";
    }

}
