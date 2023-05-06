package com.example.springaop.templatepattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class NoTemplateController {

    @GetMapping("/notemplate")
    public String noTemplate() {

        long start = System.currentTimeMillis();

        log.info("핵심 로직 실행..");

        long end = System.currentTimeMillis();

        log.info("실행 시간 = {}ms", end - start);

        return "no template";
    }
}
