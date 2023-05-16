package com.example.springaop.e_CGLIB_동적프록시;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
@RequiredArgsConstructor
public class 프록시에서_실행할_로직_구현 implements MethodInterceptor {

    private final Object target;

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        log.info("프록시 호출");
        long start = System.currentTimeMillis();
        Object result = proxy.invoke(target, args);
        long end = System.currentTimeMillis();
        log.info("프록시 호출 종료. 소요 시간 : {}ms", (end - start));
        return result;
    }
}
