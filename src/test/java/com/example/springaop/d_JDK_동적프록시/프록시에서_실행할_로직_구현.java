package com.example.springaop.d_JDK_동적프록시;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
@RequiredArgsConstructor
public class 프록시에서_실행할_로직_구현 implements InvocationHandler {

    private final Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("프록시 호출.");
        long start = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long end = System.currentTimeMillis();
        log.info("프록시 호출 종료. 소요 시간 : {}ms", (end - start));
        return result;
    }
}
