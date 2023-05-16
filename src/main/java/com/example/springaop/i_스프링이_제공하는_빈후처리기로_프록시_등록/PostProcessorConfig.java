package com.example.springaop.i_스프링이_제공하는_빈후처리기로_프록시_등록;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostProcessorConfig {

    @Bean
    public A a() {
        return new A();
    }

    @Bean
    public Advisor advisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.example.springaop.i_스프링이_제공하는_빈후처리기로_프록시_등록..call*(..))");
//        pointcut.setExpression("execution(* com.example.springaop.i_스프링이_제공하는_빈후처리기로_프록시_등록..call*(..))" +
//                " && !execution(* com.example.springaop.i_스프링이_제공하는_빈후처리기로_프록시_등록.TestController..*(..))");
        return new DefaultPointcutAdvisor(pointcut, new TimeAdvice());
    }

    @Slf4j
    static class TimeAdvice implements MethodInterceptor {
        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            log.info("프록시 호출");
            long start = System.currentTimeMillis();

            Object result = invocation.proceed();

            long end = System.currentTimeMillis();
            log.info("프록시 호출 종료. 소요 시간 : {}ms", (end - start));
            return result;
        }
    }

    @Slf4j
    static class A {

        public void callA() {
            log.info("call a");
        }

        public void cbllB() {
            log.info("cbll b");
        }
    }
}
