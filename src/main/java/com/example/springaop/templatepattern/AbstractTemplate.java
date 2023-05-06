package com.example.springaop.templatepattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long start = System.currentTimeMillis();

        call();

        long end = System.currentTimeMillis();
        log.info("실행 시간 = {}ms", end - start);
    }

    protected abstract void call();
}
