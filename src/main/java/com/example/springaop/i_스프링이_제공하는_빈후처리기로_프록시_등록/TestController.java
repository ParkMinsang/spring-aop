package com.example.springaop.i_스프링이_제공하는_빈후처리기로_프록시_등록;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final PostProcessorConfig.A a;

    @GetMapping("/a")
    public String callA() {
        a.callA();
        return "ok a";
    }

    @GetMapping("/b")
    public String callB() {
        a.cbllB();
        return "ok b";
    }
}
