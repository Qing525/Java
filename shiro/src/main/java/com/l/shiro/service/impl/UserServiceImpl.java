package com.l.shiro.service.impl;

import com.l.shiro.dao.UserDao;
import com.l.shiro.entity.User;
import com.l.shiro.service.UserSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserSerive {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectByName(String name) {
        return userDao.selectByUserName(name);
    }

    @Override
    public User findById(Long id) {

        return userDao.findById(id);
    }
}
