package com.example.springaop.d_JDK_동적프록시;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JDK_동적프록시_테스트 {

    @Test
    void dynamicA() throws Exception {
        AInt target = new AImpl();
        프록시에서_실행할_로직_구현 handler = new 프록시에서_실행할_로직_구현(target);

        AInt proxy = (AInt) Proxy.newProxyInstance(AInt.class.getClassLoader(), new Class[]{AInt.class}, handler);
        proxy.call();
        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass()); // jdk.proxy3.$Proxy11 : JDK 프록시가 생성해준 클래스
    }

    @Test
    void dynamicB() throws Exception {
        BInt target = new BImpl();
        프록시에서_실행할_로직_구현 handler = new 프록시에서_실행할_로직_구현(target);

        BInt proxy = (BInt) Proxy.newProxyInstance(BInt.class.getClassLoader(), new Class[]{BInt.class}, handler);
        proxy.call();
        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass()); // jdk.proxy3.$Proxy11 : JDK 프록시가 생성해준 클래스
    }
}
