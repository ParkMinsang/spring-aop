package com.example.springaop.strategypattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StrategyNoConcreteController {

    @GetMapping("/strategy-no-concrete")
    public String strategyNoConcrete() {

        new StrategyContext(() -> log.info("핵심 로직 실행..")).execute();

        return "strategy no concrete";
    }
}
