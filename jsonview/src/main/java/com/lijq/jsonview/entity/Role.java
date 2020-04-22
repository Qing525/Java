package com.lijq.jsonview.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.lijq.jsonview.view.RoleViews;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : lijq
 * @date : 2020/3/19 13:42
 */
@Data
@AllArgsConstructor
public class Role {

    @JsonView(RoleViews.RoleView.class)
    private Long id;

    @JsonView(RoleViews.RoleView.class)
    private String name;

}
