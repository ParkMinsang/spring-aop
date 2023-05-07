package com.example.springaop.strategypattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyParamContext {
    public void execute(Strategy strategy) {
        long start = System.currentTimeMillis();

        strategy.call();

        long end = System.currentTimeMillis();
        log.info("실행 시간 = {}ms", end - start);
    }
}
