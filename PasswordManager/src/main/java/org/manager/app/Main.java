package org.manager.app;

import org.manager.models.PasswordInfo;
import org.manager.service.PasswordRepository;
import org.manager.service.PasswordRepositoryIml;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String args[]) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("org.manager");

        PasswordRepository passwordRepository =
                context.getBean("passwordRepository", PasswordRepositoryIml.class);

//        passwordRepository.save(new PasswordInfo(1L, "ilyaszuev25@yandex.ru", "ilya228"));

        System.out.println(passwordRepository.findAll());
        System.out.println(passwordRepository.findById(0L).get());
        System.out.println(passwordRepository.findByEmail("ilyaszuev25@yandex.ru"));
    }
}
