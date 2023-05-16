package com.example.springaop.g_어드바이저_포인트컷_어드바이스;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceImpl implements ServiceInt{
    @Override
    public void call() {
        log.info("call");
    }

    @Override
    public void foo() {
        log.info("foo");
    }
}
