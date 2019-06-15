package com.ljq.mybatis.service;

import com.ljq.mybatis.entity.Test1;

import java.util.List;


/**
 * (Test1)表服务接口
 *
 * @author makejava
 * @since 2019-06-15 13:25:41
 */
public interface Test1Service {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Test1 queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Test1> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param test1 实例对象
     * @return 实例对象
     */
    Test1 insert(Test1 test1);

    /**
     * 修改数据
     *
     * @param test1 实例对象
     * @return 实例对象
     */
    Test1 update(Test1 test1);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}