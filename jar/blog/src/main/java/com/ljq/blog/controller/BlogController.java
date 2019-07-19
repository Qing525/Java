package com.ljq.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LJQ
 * @date 2019/7/18 9:11
 **/
@RestController
public class BlogController {
@RequestMapping("/hi")
public  String  home() {
    return "hi";
}
}
