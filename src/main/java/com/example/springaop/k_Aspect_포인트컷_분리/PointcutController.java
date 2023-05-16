package com.example.springaop.k_Aspect_포인트컷_분리;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PointcutController {

    @GetMapping("/multi/a")
    public String multiA() {
        log.info("multiA call");
        return "ok";
    }
}
