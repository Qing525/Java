package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ShowController {

    @GetMapping("/hello")
    public String heelo(Map<String, Object> map) {
        map.put("hello", " 您好");

        return "/show";

    }


}
