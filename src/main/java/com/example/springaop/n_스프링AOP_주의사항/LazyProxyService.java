package com.example.springaop.n_스프링AOP_주의사항;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class LazyProxyService {

    private final ObjectProvider<LazyProxyService> lazyProxyServiceProvider;

    public void external() {
        log.info("external called. call internal");
        LazyProxyService proxy = lazyProxyServiceProvider.getObject();
        proxy.internal();
    }

    public void internal() {
        log.info("internal called.");
    }

}
