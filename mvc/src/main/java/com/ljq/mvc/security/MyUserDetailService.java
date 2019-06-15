package com.ljq.mvc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author : LJQ
 * @date : 2019/6/8 12:30
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

private Logger logger= LoggerFactory.getLogger(getClass());
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        String password = passwordEncoder.encode("123456");
        logger.info("登录用户名："+s);

        logger.info("数据库密码是："+password);

        return new User("lige",password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
