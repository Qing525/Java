package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Test
    public void contextLoads() {
        // userDao.insert(new User().setAge(10).setName("Q").setEmail("1@qq.com"));
        Page<User> page = new Page<>(1, 3);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 10, 23);
        IPage<User> userIPage = userDao.selectPage(new Page<User>(3, 3), wrapper);
        System.out.println(userIPage);
    }


    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userDao.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1145899277626880002L);
        user.setAge(11);
        userDao.updateById(user);

    }

    @Test
    public void selectBatch() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<User> list = userDao.selectBatchIds(integers);
        list.forEach(System.out::println);
    }

    @Test
    public void delete() {
        Map<String, Object> map = new ConcurrentHashMap<>(16);

        map.put("name", "jack");

        userDao.deleteByMap(map);

    }
}
