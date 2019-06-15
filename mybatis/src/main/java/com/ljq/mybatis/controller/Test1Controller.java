package com.ljq.mybatis.controller;

import com.ljq.mybatis.entity.Test1;
import com.ljq.mybatis.service.Test1Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Test1)表控制层
 *
 * @author makejava
 * @since 2019-06-15 13:25:42
 */
@RestController
@RequestMapping("test1")
public class Test1Controller {
    /**
     * 服务对象
     */
    @Resource
    private Test1Service test1Service;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Test1 selectOne(@PathVariable Integer id) {
        return this.test1Service.queryById(id);
    }

}