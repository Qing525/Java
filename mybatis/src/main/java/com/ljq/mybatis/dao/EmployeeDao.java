package com.ljq.mybatis.dao;

import com.ljq.mybatis.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author LJQ
 * @date 2019/7/19 13:30
 **/
@Mapper
public interface EmployeeDao {

    void  save(Employee e);

    List<Employee> queryAll();
}
