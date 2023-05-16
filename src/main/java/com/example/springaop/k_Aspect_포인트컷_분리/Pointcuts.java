package com.example.springaop.k_Aspect_포인트컷_분리;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    // 접근자가 public 이면 Pointcut을 외부에서도 가져다 쓸 수 있다.
    @Pointcut("execution(* com.example.springaop.k_Aspect_포인트컷_분리..*(..))")
    public void myPointCut() {}

    @Pointcut("execution(* *..*Config.*(..))")
    public void configPointCut() {}
}
