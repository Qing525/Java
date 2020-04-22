package com.ljq.mybatisplus;

import com.alibaba.fastjson.JSON;
import com.ljq.mybatisplus.entity.User;
import com.ljq.mybatisplus.mapper.UserMapper;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = new User();
        user.setName("李六");
        user.setAge(10);
        userMapper.insert(user);
    }

    @Test
    void select() {
        User user = userMapper.selectById(3);
    }

    @Test
    void test(){
        User user = new EasyRandom().nextObject(User.class);
        System.out.println(JSON.toJSONString(user));
    }
}
