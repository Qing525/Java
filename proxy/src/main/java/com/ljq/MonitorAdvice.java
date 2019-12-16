package com.ljq;

import com.ljq.service.MonitorSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : LJQ
 * @date : 2019/6/3 14:37
 */
@Component
@Aspect
public class MonitorAdvice {
@Pointcut("execution(* com.ljq.service.Speakable.*(..))")
        public void pointcut(){}
   @Around("pointcut()")
public  void around(ProceedingJoinPoint pjp) throws Throwable {
       MonitorSession.begin(pjp.getSignature().getName());
       pjp.proceed();
       MonitorSession.end();
   }
}
