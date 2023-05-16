package com.example.springaop.k_Aspect_포인트컷_분리;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Date;

@Aspect
@Slf4j
public class PointCutAspect {

    @Pointcut(
            "com.example.springaop.k_Aspect_포인트컷_분리.Pointcuts.myPointCut()" +
                    " && !com.example.springaop.k_Aspect_포인트컷_분리.Pointcuts.configPointCut()")
    private void forNotConfig() {}

    @Around("forNotConfig()")
    public Object timeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Time 로그 찍기. Time - {}", new Date(System.currentTimeMillis()));
        return joinPoint.proceed();
    }

}
