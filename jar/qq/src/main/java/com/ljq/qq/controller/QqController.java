package com.ljq.qq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LJQ
 * @date 2019/7/18 9:22
 **/
@RestController
public class QqController {
@RequestMapping("/hi")
    public  String home() {
        return "hi";
    }
}

