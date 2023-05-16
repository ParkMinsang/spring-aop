package com.example.springaop.f_프록시_팩토리;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteService {

    void call() {
        log.info("구현 객체 호출");
    }
}
