package com.example.springaop.templatepattern;

import org.junit.jupiter.api.Test;

class TemplateNoConcreteControllerTest {

    TemplateNoConcreteController controller = new TemplateNoConcreteController();

    @Test
    void 템플릿패턴인데_상속받지_않고_익명클래스_사용() {
        controller.noConcrete();
    }
}