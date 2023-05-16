package com.example.springaop.a_데코레이터패턴_알아보자;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorChainComponent implements Component {

    private Component component;

    public DecoratorChainComponent(Component component) {
        this.component = component;
    }


    @Override
    public String operation() {
        log.info("time decorator 실행");
        long start = System.currentTimeMillis();
        String result = component.operation();
        long end = System.currentTimeMillis();

        log.info("소요 시간 : {}", (end - start) / 1000);

        return result;
    }
}
