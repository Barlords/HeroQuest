package esgi.cleancode;

import esgi.cleancode.exemplespring.model.HelloWorld;
import esgi.cleancode.exemplespring.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeroQuestApplication implements CommandLineRunner {

    @Autowired
    private BusinessService bs;

    public static void main(String[] args)
    {
        SpringApplication.run(HeroQuestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        HelloWorld hw = bs.getHelloWorld();
        System.out.println(hw);
    }
}