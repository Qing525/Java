package com.ljq;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LJQ
 * @date 2019/7/23 9:53
 * 通过放射越过泛型检查
 **/
public class ReflectDemo2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Class<?> clazz = list.getClass();
        Method method = clazz.getMethod("add", Object.class);
        method.invoke(list, "zs");
        System.out.println(list);
        //list.forEach(System.out::println);
    }
}
