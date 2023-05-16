package com.example.springaop.n_스프링AOP_주의사항;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallInternalService {

    public void external() {
        log.info("external called. call internal");
        internal();
    }

    public void internal() {
        log.info("internal called.");
    }
}
