package com.example.springaop.a_데코레이터패턴_알아보자;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorTest {

    @Test
    void no_decorator() throws Exception {
        Component component = new ComponentImpl();
        DecoratorClient client = new DecoratorClient(component);

        client.execute();
    }

    @Test
    void decorator() {
        Component component = new DecoratorComponent(new ComponentImpl());
        DecoratorClient client = new DecoratorClient(component);

        log.info("result = {}", client.execute());
    }

    @Test
    void chained_decorator() {
        Component realComp = new ComponentImpl();
        Component decorator1 = new DecoratorComponent(realComp);
        Component decorator2 = new DecoratorChainComponent(decorator1);

        DecoratorClient client = new DecoratorClient(decorator2);
        String result = client.execute();
        log.info("result = {}", result);
    }
}
