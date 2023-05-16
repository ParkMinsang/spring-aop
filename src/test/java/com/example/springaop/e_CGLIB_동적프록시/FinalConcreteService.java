package com.example.springaop.e_CGLIB_동적프록시;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class FinalConcreteService {

    void call() {
        log.info("final concrete service call");
    }
}
