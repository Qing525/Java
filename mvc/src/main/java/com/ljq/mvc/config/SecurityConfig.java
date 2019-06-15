package com.ljq.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : LJQ
 * @date : 2019/6/7 13:16
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean

    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    /* http.authorizeRequests()
             .anyRequest()
             .permitAll()
             .and()
             .logout()
             .permitAll()
              ;*/

        http
                .formLogin()
                .loginPage("/log-in.html")
                .loginProcessingUrl("/form/login")
                // .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/log-in.html").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                 .csrf().disable();
    }
}
