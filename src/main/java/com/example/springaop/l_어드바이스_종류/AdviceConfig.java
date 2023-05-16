package com.example.springaop.l_어드바이스_종류;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdviceConfig {

    @Bean
    public AdviceAspect adviceAspect() {
        return new AdviceAspect();
    }
}
