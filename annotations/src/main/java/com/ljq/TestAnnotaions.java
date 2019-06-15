package com.ljq;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : LJQ
 * @date : 2019/6/1 11:52
 */

public class TestAnnotaions {
    public static void main(String[] args) {
        Class clazz = User.class;
        Method[] Methods = clazz.getDeclaredMethods();

        Field[] Fields = clazz.getDeclaredFields();

        System.out.println("methods注解个数：" + Methods.length);

        System.out.println("fields注解个数：" + Fields.length);

        System.out.println("----------------------------------------------------------------");

        for (Method method : Methods) {
            if (method.isAnnotationPresent(ReqMapping.class)) {

                ReqMapping reqMapping = method.getAnnotation(ReqMapping.class);
                ReqMethod[] meth = reqMapping.meth();
                for (ReqMethod reqMethod : meth) {
                    System.out.println(reqMethod);
                }

                String[] val = reqMapping.val();

                for (String s : val) {
                    System.out.println(s);
                }
            }

        }


        for (Field field : Fields) {

            if (field.isAnnotationPresent(ReqValue.class)) {
                ReqValue reqValue = field.getAnnotation(ReqValue.class);
                System.out.println(reqValue.value1());

                System.out.println(reqValue.value2());
            }

        }
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }

}
