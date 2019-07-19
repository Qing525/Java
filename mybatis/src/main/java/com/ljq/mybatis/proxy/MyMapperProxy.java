package com.ljq.mybatis.proxy;

import lombok.Setter;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LJQ
 * @date 2019/7/19 9:47
 **/
@Setter
public class MyMapperProxy <T>implements InvocationHandler {
    public Class <T> MapperInterface;
    private SqlSession session;

    public T getProxy() {
    return (T) Proxy.newProxyInstance(MapperInterface.getClassLoader(),new Class[]{MapperInterface},this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String nameSpace=MapperInterface.getName();
        String methodName=method.getName();
        String sql=nameSpace+"."+methodName;
        return session.selectOne(sql);
    }
}
