package com.ljq.aop01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : lijq
 * @date : 2020/4/5 13:38
 */
@Aspect
@Component
public class AopHandler {


    @Pointcut("execution(public * com.ljq.aop01.controller.TestAopController .*(..))")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("xx");
        long l = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long l1 = System.currentTimeMillis();
        System.out.println(pjp.getSignature().getName() + "耗时 " + (l1 - l) + " ms");
        return proceed;
    }
}
