package com.example.springaop.e_CGLIB_동적프록시;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceImpl implements ServiceInt{

    @Override
    public void call() {
        log.info("call service");
    }
}
