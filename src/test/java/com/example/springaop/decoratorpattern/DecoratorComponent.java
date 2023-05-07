package com.example.springaop.decoratorpattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorComponent implements Component {

    private Component component;

    public DecoratorComponent(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("decorator message");
        return component.operation() + " created by decorator";
    }
}
