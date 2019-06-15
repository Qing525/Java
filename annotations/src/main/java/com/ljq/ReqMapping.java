package com.ljq;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : LJQ
 * @date : 2019/6/1 11:42
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReqMapping {

    ReqMethod[] meth() default {};

    String [] val()  default "";
}
