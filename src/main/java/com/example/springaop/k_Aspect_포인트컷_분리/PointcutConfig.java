package com.example.springaop.k_Aspect_포인트컷_분리;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PointcutConfig {

    @Bean
    public PointCutAspect multiAdvisorAspect() {
        return new PointCutAspect();
    }
}
