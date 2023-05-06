package com.example.springaop.templatepattern;

import org.junit.jupiter.api.Test;

class NoTemplateControllerTest {

    NoTemplateController controller = new NoTemplateController();

    @Test
    void 템플릿패턴_사용하지_않음() {
        controller.noTemplate();
    }
}