package com.example.springaop.j_Aspect_어노테이션으로_Advisor_생성;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopConfig {

    @Bean
    public TimeAspect timeAspect() {
        return new TimeAspect();
    }
}
