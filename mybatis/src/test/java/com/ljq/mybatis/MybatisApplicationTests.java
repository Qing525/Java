package com.ljq.mybatis;

import com.ljq.mybatis.dao.DeptDao;
import com.ljq.mybatis.dao.EmployeeDao;
import com.ljq.mybatis.dao.Test1Dao;
import com.ljq.mybatis.entity.Dept;
import com.ljq.mybatis.entity.Employee;
import com.ljq.mybatis.entity.Test1;
import com.ljq.mybatis.proxy.MyMapperProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MybatisApplicationTests {
    @Resource
    private Test1Dao test1Dao;
    @Resource
    private DeptDao deptDao;
    @Autowired
    private EmployeeDao employeeDao;


    @Test
    public void test() {
        List<Test1> tt = new ArrayList<>(10);
        Test1 t1 = new Test1();
        Test1 t2 = new Test1();
        Test1 t3 = new Test1();
        t1.setId(114);
        t1.setName("11");
        t1.setDate(new Date());
        t2.setId(115);
        t2.setName("11");
        t2.setDate(new Date());
        t3.setId(116);
        t3.setDate(new Date());
        t3.setName("11");
        tt.add(t1);
        tt.add(t2);
        tt.add(t3);
        log.info("生效数量：" + test1Dao.insertBatch(tt));

    }

    @Test
    public void test2() {

        List<Test1> list1 = Arrays.asList(new Test1(1), new Test1(2));

        log.info("生效数量：" + test1Dao.deleteBatch(list1));

    }

    @Test
    public void test3() throws Exception {
        SqlSession session = new SqlSessionFactoryBean().getObject().openSession();
        MyMapperProxy<Test1Dao> myMapper = new MyMapperProxy<>();
        myMapper.setMapperInterface(Test1Dao.class);
        myMapper.setSession(session);
        Test1Dao proxy = myMapper.getProxy();
        Test1 test1 = proxy.queryById(1);

        System.out.println(test1.getClass());
    }
    @Test
    public void test4(){
        Dept dept=new Dept();
        dept.setName("A部");
        Employee e=new Employee();
        e.setName("zs");
        e.setDept(dept);
        Employee e1=new Employee();
        e1.setName("ls");
        e1.setDept(dept);
        deptDao.save(dept);
        employeeDao.save(e);
        employeeDao.save(e1);
    }
    @Test
    public void  List() {
        employeeDao.queryAll().forEach(System.out::println);
    }
}
