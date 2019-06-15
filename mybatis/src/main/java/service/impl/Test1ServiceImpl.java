package com.ljq.mybatis.service.impl;

import com.ljq.mybatis.dao.Test1Dao;
import com.ljq.mybatis.entity.Test1;
import com.ljq.mybatis.service.Test1Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * (Test1)表服务实现类
 *
 * @author makejava
 * @since 2019-06-15 13:25:42
 */
@Service("test1Service")
public class Test1ServiceImpl implements Test1Service {
    @Resource
    private Test1Dao test1Dao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Test1 queryById(Integer id) {
        return this.test1Dao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Test1> queryAllByLimit(int offset, int limit) {
        return this.test1Dao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param test1 实例对象
     * @return 实例对象
     */
    @Override
    public Test1 insert(Test1 test1) {
        this.test1Dao.insert(test1);
        return test1;
    }

    /**
     * 修改数据
     *
     * @param test1 实例对象
     * @return 实例对象
     */
    @Override
    public Test1 update(Test1 test1) {
        this.test1Dao.update(test1);
        return this.queryById(test1.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.test1Dao.deleteById(id) > 0;
    }
}