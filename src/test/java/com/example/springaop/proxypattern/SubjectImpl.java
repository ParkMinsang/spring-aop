package com.example.springaop.proxypattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubjectImpl implements Subject {

    @Override
    public String operation() {
        log.info("실제 객체 호출");
        sleep();
        return "subject impl";
    }

    void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
