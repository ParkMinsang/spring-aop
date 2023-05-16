package com.example.springaop.e_CGLIB_동적프록시;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CGLIB_동적프록시_테스트 {

    @Test
    void cglib() throws Exception {
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new 프록시에서_실행할_로직_구현(target));

        ConcreteService proxy = (ConcreteService) enhancer.create();
        proxy.call();
        log.info("target - {}", target.getClass());
        log.info("proxy - {}", proxy.getClass());
    }

    @Test
    void cglib_fail() throws Exception {
        FinalConcreteService target = new FinalConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(FinalConcreteService.class);
        enhancer.setCallback(new 프록시에서_실행할_로직_구현(target));

        FinalConcreteService proxy = (FinalConcreteService) enhancer.create();
        proxy.call();
        log.info("target - {}", target.getClass());
        log.info("proxy - {}", proxy.getClass());
    }
}
