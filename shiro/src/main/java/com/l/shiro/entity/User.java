package com.l.shiro.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class User implements Serializable {

    private Long id;

    private String name;

    private Integer age;

    private String password;

    private String email;
    
    private String perms;
    

}
