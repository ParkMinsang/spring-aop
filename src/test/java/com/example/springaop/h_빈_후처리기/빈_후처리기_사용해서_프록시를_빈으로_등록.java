package com.example.springaop.h_빈_후처리기;

import com.example.springaop.f_프록시_팩토리.TimeAdvice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class 빈_후처리기_사용해서_프록시를_빈으로_등록 {

    @Test
    void 빈_후처리기로_프록시_등록_테스트() throws Exception {
        ApplicationContext ac = new AnnotationConfigReactiveWebApplicationContext(ConfigAB.class);
        A beanA = ac.getBean(A.class);
        beanA.callA();

        B beanB = ac.getBean(B.class);
        beanB.callB();
    }

    @Slf4j
    @Configuration
    static class ConfigAB {

        @Bean
        public A a() {
            return new A();
        }

        @Bean
        public B b() {
            return new B();
        }

        @Bean
        public BBeanPostProcessor processor() {
            return new BBeanPostProcessor("com.example.springaop.h_", new DefaultPointcutAdvisor(Pointcut.TRUE, new TimeAdvice()));
        }
    }

    @Slf4j
    static class A {

        A() {
            log.info("A 생성자");
        }

        public void callA() {
            log.info("call a");
        }
    }

    @Slf4j
    static class B {

        public void callB() {
            log.info("call b");
        }
    }

    @Slf4j
    @RequiredArgsConstructor
    static class BBeanPostProcessor implements BeanPostProcessor {

        private final String basePackage;

        private final Advisor advisor;

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            log.info("beanName - {}, bean - {}", beanName, bean);

            String packageName = bean.getClass().getPackageName();

            if (packageName.startsWith(basePackage)) {
                ProxyFactory proxyFactory = new ProxyFactory(bean);
                proxyFactory.addAdvisor(advisor);
                return proxyFactory.getProxy();
            }

            return bean;
        }
    }
}
