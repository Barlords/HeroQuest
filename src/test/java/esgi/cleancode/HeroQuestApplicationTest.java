package esgi.cleancode;

import esgi.cleancode.exemplespring.service.BusinessService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
class HeroQuestApplicationTest {

    @Autowired
    private BusinessService bs;

    @Test
    void loads_context() {}

    @Test
    void get_hello_world_test() {
        String expected = "Hello World!";

        String result = bs.getHelloWorld().getValue();

        Assertions.assertEquals(expected, result);
    }
}
