package com.example.springaop.b_프록시패턴_비슷하니까_안알아보자;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxySubject implements Subject {

    private Subject subject;

    private String cacheValue;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String operation() {
        log.info("proxy 호출");
        if (cacheValue == null) {
            cacheValue = subject.operation();
        }

        return cacheValue;
    }
}
