package com.l.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {


    /**
     * 创建 ShiroFilterFactoryBean
     * 内置过滤器
     * anon    无需认证就能访问
     * <p>
     * authc   必须认证才能访问
     * <p>
     * users   使用RememberMe 可以访问
     * <p>
     * perms   必须得到资源权限才能访问
     * <p>
     * role     必须得到资源权限才能访问
     */
    @Bean
    public ShiroFilterFactoryBean getBean(@Qualifier("webSecurityManager") DefaultWebSecurityManager webSecurityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();

        filterFactoryBean.setSecurityManager(webSecurityManager);

        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/test", "anon");

        filterMap.put("/login", "anon");

        filterMap.put("/add", "perms[user:add]");
        filterMap.put("/update", "perms[user:update]");

        filterMap.put("/*", "authc");

        filterFactoryBean.setFilterChainDefinitionMap(filterMap);
        filterFactoryBean.setLoginUrl("/toLogin");
        filterFactoryBean.setUnauthorizedUrl("/noAuth");
        return filterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     *
     * @return
     */
    @Bean(name = "webSecurityManager")
    public DefaultWebSecurityManager webSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {

        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(userRealm);

        //开启RemeberMe功能
        webSecurityManager.setRememberMeManager(cookieRememberMeManager());
        return webSecurityManager;

    }

    @Bean(name = "userRealm")
    public UserRealm realm() {

        return new UserRealm();
    }

    /**
     * 配置方言，可以在html里 引用 shiro: xx  标签
     *
     * @return
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

    @Bean
    public SimpleCookie cookie() {
        SimpleCookie cookie = new SimpleCookie("remCookie");

        cookie.setMaxAge(60);

        return cookie;

    }

    @Bean
    public CookieRememberMeManager cookieRememberMeManager() {

        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(cookie());
        rememberMeManager.setCipherKey(Base64.decode(""));
        return rememberMeManager;
    }
}
