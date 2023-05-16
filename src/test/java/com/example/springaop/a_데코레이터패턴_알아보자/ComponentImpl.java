package com.example.springaop.a_데코레이터패턴_알아보자;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComponentImpl implements Component {

    @Override
    public String operation() {
        log.info("component impl 호출");
        return "component impl";
    }
}
