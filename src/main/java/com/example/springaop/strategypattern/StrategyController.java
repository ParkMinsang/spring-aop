package com.example.springaop.strategypattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StrategyController {

    private final StrategyContext context = new StrategyContext(new StrategyImpl());

    @GetMapping("/strategy")
    public String strategy() {

        context.execute();

        return "strategy";
    }
}
