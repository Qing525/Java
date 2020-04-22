package com.lijq.jsonview.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.lijq.jsonview.view.DeptViews;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : lijq
 * @date : 2020/3/19 13:14
 */
@Data
@AllArgsConstructor
public class Dept {

    @JsonView(DeptViews.DeptView.class)
    private Long id;

    @JsonView(DeptViews.DeptView.class)
    private String name;
}
