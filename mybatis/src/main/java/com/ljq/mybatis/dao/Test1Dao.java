package com.ljq.mybatis.dao;

import com.ljq.mybatis.entity.Test1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Test1)表数据库访问层
 *
 * @author makejava
 * @since 2019-06-15 13:25:39
 */
@Mapper
public interface Test1Dao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Test1 queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Test1> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param test1 实例对象
     * @return 对象列表
     */
    List<Test1> queryAll(Test1 test1);

    /**
     * 新增数据
     *
     * @param test1 实例对象
     * @return 影响行数
     */
    int insert(Test1 test1);

    /**
     * 修改数据
     *
     * @param test1 实例对象
     * @return 影响行数
     */
    int update(Test1 test1);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     *批量插入
     *
     * @param  test1 集合
     * @return 影响行数
     */
    int insertBatch(List<Test1> test1);

    int deleteBatch(List<Test1> test1);

}