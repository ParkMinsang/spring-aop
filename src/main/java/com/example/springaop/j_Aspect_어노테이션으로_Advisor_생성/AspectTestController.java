package com.example.springaop.j_Aspect_어노테이션으로_Advisor_생성;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AspectTestController {

    @GetMapping("/aspect/a")
    public String a() {
        log.info("Aspect Test Controller 호출");
        return "ok";
    }
}
