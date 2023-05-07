package com.example.springaop.decoratorpattern;

public class DecoratorClient {

    private Component component;

    public DecoratorClient(Component component) {
        this.component = component;
    }

    public String execute() {
        return component.operation();
    }
}
