package com.example.springaop.strategypattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StrategyParamController {

    private final StrategyParamContext context = new StrategyParamContext();

    @GetMapping("/strategy-param")
    public String strategyParam() {
        context.execute(() -> log.info("핵심 로직 실행.."));

        return "strategy param";
    }
}
