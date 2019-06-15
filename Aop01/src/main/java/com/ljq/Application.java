package com.ljq;

import com.ljq.service.PersonProxyFactory;
import com.ljq.service.Speakable;
import com.ljq.service.impl.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Autowired
    private Speakable personSpring;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {

        return args -> {
         /*
            System.out.println("******** spring aop ******** ");
            personSpring.sayHi();
            personSpring.sayBye();
            System.exit(0);
         */
/*
            System.out.println("******** jdk dynamic proxy ******** ");
            Speakable jdkProxy = PersonProxyFactory.newJdkProxy();
            jdkProxy.sayHi();
            jdkProxy.sayBye();
            */

            // cglib dynamic proxy

            System.out.println("******** cglib proxy ******** ");
            Person cglibProxy = PersonProxyFactory.newCglibProxy();
            cglibProxy.sayHi();
            cglibProxy.sayBye();
        };
    }
}
