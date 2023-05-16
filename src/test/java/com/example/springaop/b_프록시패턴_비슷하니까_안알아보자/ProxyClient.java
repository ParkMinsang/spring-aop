package com.example.springaop.b_프록시패턴_비슷하니까_안알아보자;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProxyClient {

    private final Subject subject;

    public void execute() {
        subject.operation();
    }
}
