package com.lijq.jsonview.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.lijq.jsonview.view.UserViews;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : lijq
 * @date : 2020/3/19 13:12
 */
@Data
@AllArgsConstructor
public class User {

    @JsonView(UserViews.UserSimpleView.class)
    private Long id;

    @JsonView(UserViews.UserSimpleView.class)
    private String name;

    @JsonView(UserViews.UserDetailView.class)
    private String password;

    @JsonView(UserViews.UserDeptView.class)
    private Dept dept;

    @JsonView(UserViews.UserRoleView.class)
    private Role role;
}
