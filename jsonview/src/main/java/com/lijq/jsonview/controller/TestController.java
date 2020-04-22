package com.lijq.jsonview.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lijq.jsonview.entity.Dept;
import com.lijq.jsonview.entity.Role;
import com.lijq.jsonview.entity.User;
import com.lijq.jsonview.view.ResultViews;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : lijq
 * @date : 2020/3/19 13:25
 */
@RestController
public class TestController {

    @GetMapping
    @JsonView(ResultViews.ResultUserDeptRoleView.class)
    public User getUser() {

        return new User(1L, "张三", "123***", new Dept(1L, "dept1"), new Role(1L, "Java"));

    }

}
