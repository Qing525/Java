package com.l.shiro.service;

import com.l.shiro.entity.User;

public interface UserSerive {

    User selectByName(String name);

    User findById(Long id);
}
