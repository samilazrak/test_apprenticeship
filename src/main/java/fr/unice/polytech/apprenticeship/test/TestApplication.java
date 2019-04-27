package fr.unice.polytech.apprenticeship.test;

import fr.unice.polytech.apprenticeship.test.services.RegisterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        //SpringApplication.run(TestApplication.class, args);
        ApplicationContext context = SpringApplication.
                run(TestApplication.class,args);
        System.out.println("Contains A  "+context.
                containsBeanDefinition("aspectChecker"));
        System.out.println("Contains A  "+context.
                containsBeanDefinition("displayAspect"));
    }

}
