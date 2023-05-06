package com.example.springaop.templatepattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TemplateNoConcreteController {

    @GetMapping("/noconcretetemplate")
    public String noConcrete() {
        new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("핵심 로직 실행..");
            }
        }.execute();

        return "no concrete";
    }
}
