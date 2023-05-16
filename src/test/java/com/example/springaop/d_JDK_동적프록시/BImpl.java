package com.example.springaop.d_JDK_동적프록시;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImpl implements BInt {
    @Override
    public String call() {
        log.info("call b");
        return "b";
    }
}
