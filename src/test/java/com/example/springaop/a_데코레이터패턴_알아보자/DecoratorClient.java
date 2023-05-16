package com.example.springaop.a_데코레이터패턴_알아보자;

public class DecoratorClient {

    private Component component;

    public DecoratorClient(Component component) {
        this.component = component;
    }

    public String execute() {
        return component.operation();
    }
}
