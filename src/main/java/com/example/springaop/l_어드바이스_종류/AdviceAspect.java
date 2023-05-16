package com.example.springaop.l_어드바이스_종류;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Slf4j
@Aspect
public class AdviceAspect {

    @Pointcut("execution(* *..l_어드바이스_종류.AdviceController.*(..))")
    private void forController() {
    }

    @Before("forController()")
    public void before() {
        log.info("before aspect");
    }

    @Before("forController()")
    public void before2(JoinPoint joinPoint) {
        log.info("before aspect. joinPoint - {}", joinPoint.getSignature());
    }

    @AfterReturning(value = "forController()", returning = "result")
    public String afterReturning(JoinPoint joinPoint, Object result) {
        log.info("after returning. result - {}", result);
        return "bad"; // result 를 바꿀수는 없다.
    }

    @AfterThrowing(value = "forController()", throwing = "ex")
    public void afterThrow(JoinPoint joinPoint, Exception ex) {
        log.error("exception occurred..{}", ex.getMessage());
    }

    @After("forController()")
    public void after(JoinPoint joinPoint) {
        log.info("after - {}", joinPoint.getSignature());
    }

    /**
     * Around 사용 시
     * 아래 코드의 문제점
     */
//    @Around("forController()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        String result = "";
//        try {
//            log.info("before aspect");
//
//            log.info("after returning. result - {}", result);
//        } catch (RuntimeException e) {
//            log.error("exception occurred..{}", e.getMessage());
//            result = "bad";
//        } finally {
//            log.info("after - {}", joinPoint.getSignature());
//        }
//        return result;
//    }
}
