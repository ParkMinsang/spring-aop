package com.example.springaop.f_프록시_팩토리;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

@Slf4j
public class 프록시_팩토리_테스트 {

    @Test
    void 인터페이스_있을때_프록시_팩토리는_JDK_동적프록시() throws Exception {
        ServiceInt target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInt proxy = (ServiceInt) proxyFactory.getProxy();
        proxy.call();
        log.info("targetClass - {}", target.getClass());
//        log.info("proxyClass - {}", proxy.getClass());

        /**
         * 아래 결과가 어떻게 될까요
         */
        Assertions.assertTrue(AopUtils.isAopProxy(proxy));
        Assertions.assertTrue(AopUtils.isJdkDynamicProxy(proxy));
        Assertions.assertTrue(AopUtils.isCglibProxy(proxy));
    }

    @Test
    void 구체클래스만_있을땐_프록시_팩토리는_CGLIB_동적프록시() {
        ConcreteService target = new ConcreteService();

        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();
        proxy.call();
        log.info("targetClass - {}", target.getClass());
//        log.info("proxyClass - {}", proxy.getClass());

        /**
         * 아래 결과가 어떻게 될까요
         */
        Assertions.assertTrue(AopUtils.isAopProxy(proxy));
        Assertions.assertTrue(AopUtils.isJdkDynamicProxy(proxy));
        Assertions.assertTrue(AopUtils.isCglibProxy(proxy));
    }

    @Test
    void 프록시_팩토리_setProxyTargetClass_true() throws Exception {
        ServiceInt target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        proxyFactory.setProxyTargetClass(true);
        ServiceInt proxy = (ServiceInt) proxyFactory.getProxy();
        proxy.call();
        log.info("targetClass - {}", target.getClass());
//        log.info("proxyClass - {}", proxy.getClass());

        /**
         * 아래 결과가 어떻게 될까요
         */
        Assertions.assertTrue(AopUtils.isAopProxy(proxy));
        Assertions.assertTrue(AopUtils.isJdkDynamicProxy(proxy));
        Assertions.assertTrue(AopUtils.isCglibProxy(proxy));
    }
}
