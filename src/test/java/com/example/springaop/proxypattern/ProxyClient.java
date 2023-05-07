package com.example.springaop.proxypattern;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProxyClient {

    private final Subject subject;

    public void execute() {
        subject.operation();
    }
}
