package com.example.springaop.g_어드바이저_포인트컷_어드바이스;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;

public class 포인트컷 implements Pointcut {

    @Override
    public ClassFilter getClassFilter() {
        return ClassFilter.TRUE;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new 메소드_매쳐();
    }

    @Slf4j
    static class 메소드_매쳐 implements MethodMatcher {

        private String matchName = "call";

        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            boolean result = method.getName().equals(matchName);
            log.info("메소드 매쳐 결과 - {}, 호출한 메소드 이름 - {}", result, method.getName());
            return result;
        }

        @Override
        public boolean isRuntime() {
            return false;
        }

        @Override
        public boolean matches(Method method, Class<?> targetClass, Object... args) {
            return false;
        }
    }
}
