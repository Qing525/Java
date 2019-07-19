package com.l.shiro.config;

import com.l.shiro.entity.User;
import com.l.shiro.service.UserSerive;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private UserSerive userSerive;

    /**
     * @param principalCollection 授权
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();

        //1.当前用户
        Subject currentUser = SecurityUtils.getSubject();

        User user = (User) currentUser.getPrincipal();

        //2.查找权限

        User user1 = userSerive.findById(user.getId());


        authenticationInfo.addStringPermission(user1.getPerms());



        return authenticationInfo;
    }

    /**
     * @param authenticationToken 认证
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {


        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        User user = userSerive.selectByName(token.getUsername());

        if (user == null) {
            return null;
        }

        log.info(token.getUsername()+"-----"+user.getPassword()+"------"+getName()+"====="+user+"--------"+token);

        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
