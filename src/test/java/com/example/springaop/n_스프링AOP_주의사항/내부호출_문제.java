package com.example.springaop.n_스프링AOP_주의사항;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(InternalAspect.class)
public class 내부호출_문제 {

    @Autowired
    CallInternalService internalService;

    @Autowired
    LazyProxyService proxyService;

    @Test
    void 외부메소드_호출_테스트() throws Exception {
        internalService.external();
    }

    @Test
    void 내부메소드_호출_테스트() throws Exception {
        internalService.internal();
    }

    @Test
    void 프록시_지연조회() {
        proxyService.external();
    }
}
