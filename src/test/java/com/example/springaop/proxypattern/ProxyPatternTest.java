package com.example.springaop.proxypattern;


import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxy() throws Exception {
        Subject subject = new SubjectImpl();
        ProxyClient client = new ProxyClient(subject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void proxyTest() throws Exception {
        ProxySubject subject = new ProxySubject(new SubjectImpl());
        ProxyClient client = new ProxyClient(subject);

        client.execute();
        client.execute();
        client.execute();
    }
}
