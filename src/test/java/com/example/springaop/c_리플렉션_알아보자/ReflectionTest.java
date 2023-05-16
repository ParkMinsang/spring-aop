package com.example.springaop.c_리플렉션_알아보자;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection() throws Exception {
        Class helloClass = Class.forName("com.example.springaop.c_리플렉션_알아보자.ReflectionTest$Hello");

        Hello target = new Hello();
        Method method1 = helloClass.getMethod("callA");
        Method method2 = helloClass.getMethod("callB");

        log.info("method1 run");
        dynamicCall(method1, target);
        log.info("-------------------------");
        log.info("method2 run");
        dynamicCall(method2, target);
    }

    private Object dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        log.info("시작시간 {}", System.currentTimeMillis());
        Object result = method.invoke(target);
        log.info("종료시간 {}", System.currentTimeMillis());

        return result;
    }

    @Slf4j
    static class Hello {

        public String callA() {
            log.info("call A");
            return "A";
        }

        public String callB() {
            log.info("call B");
            return "B";
        }
    }

}
