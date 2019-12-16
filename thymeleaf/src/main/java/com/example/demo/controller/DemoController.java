package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String xx(Model model) {

        List<User> list = userService.selectAll();

        model.addAttribute("list", list);

        return "/list";
    }

    @GetMapping("/form")
    public String xxx() {

        return "/reg";
    }


    @PostMapping("/form")

    public String x(@RequestBody User user, Model model) {
        User u = new User();
        u.setAge(user.getAge()).setName(user.getName()).setEmail(user.getEmail());

        userService.insert(u);

        model.addAttribute("user", u);

        return "/reg";
    }

}
