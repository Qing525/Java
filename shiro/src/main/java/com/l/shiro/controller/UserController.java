package com.l.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/login";
    }

    @RequestMapping("/add")
    public String add() {
        return "/add";
    }

    @RequestMapping("/update")
    public String update() {
        return "/update";
    }

    @RequestMapping("/noAuth")
    public String noAuth() {

        return "/noAuth";
    }

    @RequestMapping("/test")
    public String test() {

        return "/test";
    }

    /***
     *  使用 shiro 进行 登录
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("/login")

    public String login(String name, String pwd, Model model,boolean remCookie) {
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, pwd,remCookie);

        //3.执行登录方法
        try {
            System.out.println(token);

            subject.login(token);

            return "redirect:/test";

        } catch (UnknownAccountException e) {

            model.addAttribute("msg", "用户不存在");

            return "/login";

        } catch (IncorrectCredentialsException e) {

            model.addAttribute("msg", "用户名或密码错误");

            return "/login";
        }
    }

}
