package com.ljq.wx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LJQ
 * @date 2019/7/18 9:16
 **/
@RestController
public class WxController {
    @RequestMapping("/hi")

    public  String hi(){

        return "hi";
    }
}
