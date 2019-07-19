package com.ljq.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author LJQ
 * @date 2019/7/19 13:25
 **/
@Getter
@Setter
public class Employee {
    private Long id;
    private String name;
    private Dept dept;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept=" + dept +
                '}';
    }
}
