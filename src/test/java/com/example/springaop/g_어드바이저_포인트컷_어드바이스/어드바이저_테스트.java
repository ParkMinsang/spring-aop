package com.example.springaop.g_어드바이저_포인트컷_어드바이스;

import com.example.springaop.f_프록시_팩토리.TimeAdvice;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

@Slf4j
public class 어드바이저_테스트 {

    @Test
    void 어드바이저_테스트1() throws Exception {
        ServiceInt target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(Pointcut.TRUE, new TimeAdvice());
        proxyFactory.addAdvisor(advisor);

        ServiceInt proxy = (ServiceInt) proxyFactory.getProxy();
        proxy.call();
    }

    @Test
    void 포인트컷_테스트() throws Exception {
        ServiceInt target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(new 포인트컷(), new TimeAdvice());
        proxyFactory.addAdvisor(advisor);

        ServiceInt proxy = (ServiceInt) proxyFactory.getProxy();
        proxy.call();
        log.info("-------------");
        proxy.foo();
    }

    @Test
    void 스프링_포인트컷_테스트() throws Exception {
        ServiceInt target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("foo");
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new TimeAdvice());
        proxyFactory.addAdvisor(advisor);

        ServiceInt proxy = (ServiceInt) proxyFactory.getProxy();
        proxy.call();
        log.info("-------------");
        proxy.foo();
    }
}
