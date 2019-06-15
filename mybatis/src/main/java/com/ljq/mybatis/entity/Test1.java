package com.ljq.mybatis.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Test1)实体类
 *
 * @author makejava
 * @since 2019-06-15 13:25:35
 */
public class Test1 implements Serializable {
    private static final long serialVersionUID = -73733234698814875L;
    
    private Integer id;
    
    private String name;
    
    private Date date;


    public Test1(){}

    public Test1(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}