package com.example.springaop.j_Aspect_어노테이션으로_Advisor_생성;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class TimeAspect {

    @Around("execution(* com.example.springaop.j_Aspect_어노테이션으로_Advisor_생성..*(..))" +
            "&& !execution(* com.example.springaop.j_Aspect_어노테이션으로_Advisor_생성.AopConfig.*(..))") // Pointcut
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        // Advice

        log.info("Aspect 어노테이션으로 생성한 Advisor에 의한 프록시 호출");
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        log.info("Aspect 어노테이션으로 생성한 Advisor에 의한 프록시 호출 종료. 소요 시간 : {}ms", (end - start));
        return result;
    }
}
