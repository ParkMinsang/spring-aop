package com.example.springaop.strategypattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyImpl implements Strategy {
    @Override
    public void call() {
        log.info("핵심 기능 실행..");
    }
}
