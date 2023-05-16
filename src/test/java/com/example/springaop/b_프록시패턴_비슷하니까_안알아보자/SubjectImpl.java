package com.example.springaop.b_프록시패턴_비슷하니까_안알아보자;

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
