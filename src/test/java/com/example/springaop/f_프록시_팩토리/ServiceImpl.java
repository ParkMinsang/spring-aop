package com.example.springaop.f_프록시_팩토리;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceImpl implements ServiceInt {

    @Override
    public void call() {
        log.info("call service");
    }
}
