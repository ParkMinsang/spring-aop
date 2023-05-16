package com.example.springaop.e_CGLIB_동적프록시;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteService {

    void call() {
        log.info("구현 객체 호출");
    }
}
