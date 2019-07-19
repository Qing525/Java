package com.ljq.mybatis.dao;

import com.ljq.mybatis.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LJQ
 * @date 2019/7/19 13:30
 **/
@Mapper
public interface DeptDao {
void   save(Dept dept);
}

