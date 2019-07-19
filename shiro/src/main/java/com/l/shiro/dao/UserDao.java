package com.l.shiro.dao;

import com.l.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

      User selectByUserName(String name);

      User findById(Long id);

}
