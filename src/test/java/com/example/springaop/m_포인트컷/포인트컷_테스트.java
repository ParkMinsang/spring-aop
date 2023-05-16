package com.example.springaop.m_포인트컷;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

@Slf4j
public class 포인트컷_테스트 {

    @Test
    void execution_포인트컷은_메소드_정보를_매칭해서_대상을_찾아낸다() throws Exception {
        Method helloMethod = A.class.getMethod("hello", String.class);
        log.info("helloMethod - {}", helloMethod);
//로그 결과 -> public java.lang.String com.example.springaop.m_포인트컷.포인트컷_테스트$A.hello(java.lang.String)

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

        /**
         * 패키지 매칭
         */
//        pointcut.setExpression("execution(public String com.example.springaop.m_포인트컷.포인트컷_테스트$A.hello(String))");
//        Assertions.assertTrue(pointcut.matches(helloMethod, A.class));

//        pointcut.setExpression("execution(* com.example.springaop.*(..))");
//        Assertions.assertTrue(pointcut.matches(helloMethod, A.class));

//        pointcut.setExpression("execution(* com.example.springaop..*(..))");
//        Assertions.assertTrue(pointcut.matches(helloMethod, A.class));

//        pointcut.setExpression("execution(* hello(..))");
//        Assertions.assertTrue(pointcut.matches(helloMethod, A.class));

//        pointcut.setExpression("execution(* *(..))");
//        Assertions.assertTrue(pointcut.matches(helloMethod, A.class));

        /**
         * 타입 매칭
         */
//        pointcut.setExpression("execution(* hello(..))");
//        Assertions.assertTrue(pointcut.matches(helloMethod, A.class));

//        pointcut.setExpression("execution(* hello(..))");
//        Assertions.assertTrue(pointcut.matches(helloMethod, AInterface.class));

        /**
         * 파라미터 매칭
         */
//        pointcut.setExpression("execution(* *(String))");
//        Assertions.assertTrue(pointcut.matches(helloMethod, A.class));

//        pointcut.setExpression("execution(* *())");
//        Assertions.assertFalse(pointcut.matches(helloMethod, A.class));

//        pointcut.setExpression("execution(* *(*))");
//        Assertions.assertTrue(pointcut.matches(helloMethod, A.class));

//        pointcut.setExpression("execution(* *(..))");
//        Assertions.assertTrue(pointcut.matches(helloMethod, A.class));

        pointcut.setExpression("execution(* *(String, ..))");
        Assertions.assertTrue(pointcut.matches(helloMethod, A.class));
    }

    @Test
    void 실습해볼까요() throws Exception {
        /**
         * A 클래스의 bye 메소드에만 맞는 execution 을 작성해봅시다!
         * ??? 두 군데를 채워주세요
         */
        Method helloMethod = A.class.getMethod("hello", String.class);
//        Method byeMethod = A.class.getMethod(???);
//        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//        pointcut.setExpression(???);
//        Assertions.assertFalse(pointcut.matches(helloMethod, A.class));
//        Assertions.assertTrue(pointcut.matches(byeMethod, A.class));

    }

    interface AInterface {
        String hello(String args);
    }

    static class A implements AInterface {
        @Override
        public String hello(String args) {
            return "ok";
        }

        public String bye(int a) {
            return "ok";
        }
    }
}
