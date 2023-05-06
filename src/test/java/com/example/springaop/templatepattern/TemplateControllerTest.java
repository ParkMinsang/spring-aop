package com.example.springaop.templatepattern;

import org.junit.jupiter.api.Test;

class TemplateControllerTest {

    TemplateController controller = new TemplateController();

    @Test
    void 템플릿패턴_사용하면() {
        controller.templatePattern();
    }
}