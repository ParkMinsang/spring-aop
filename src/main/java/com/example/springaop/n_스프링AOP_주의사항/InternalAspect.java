package com.example.springaop.n_스프링AOP_주의사항;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class InternalAspect {

    @Before("execution(* com.example.springaop.n_스프링AOP_주의사항.*Service.*(..))")
    public void log(JoinPoint joinPoint) {
        log.info("aop 적용되면 이 로그가 보입니다. from - {}", joinPoint.getSignature());
    }
}
