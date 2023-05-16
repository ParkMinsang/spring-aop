package com.example.springaop.l_어드바이스_종류;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdviceController {

    @GetMapping("/advice")
    public String advice() {
        return "ok";
    }

    @GetMapping("/advice/error")
    public String error() {
        throw new RuntimeException("예외 발생");
    }
}
