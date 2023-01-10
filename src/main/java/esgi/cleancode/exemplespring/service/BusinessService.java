package esgi.cleancode.exemplespring.service;

import esgi.cleancode.exemplespring.model.HelloWorld;
import org.springframework.stereotype.Component;

@Component
public class BusinessService {

    public HelloWorld getHelloWorld() {
        return new HelloWorld();
    }

}
