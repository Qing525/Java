package com.ljq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
//    @Autowired
//    private Speakable personSpring;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext context) {
//
//        return args -> {
//         /*
//            System.out.println("******** spring aop ******** ");
//            personSpring.sayHi();
//            personSpring.sayBye();
//            System.exit(0);
//         */
///*
//            System.out.println("******** jdk dynamic proxy ******** ");
//            Speakable jdkProxy = PersonProxyFactory.newJdkProxy();
//            jdkProxy.sayHi();
//            jdkProxy.sayBye();
//            */
//
//            // cglib dynamic proxy
//
//            System.out.println("******** cglib proxy ******** ");
//            Person cglibProxy = PersonProxyFactory.newCglibProxy();
//            cglibProxy.sayHi();
//            cglibProxy.sayBye();
//        };
//    }
}
