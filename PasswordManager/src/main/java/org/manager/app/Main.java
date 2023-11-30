package org.manager.app;

import org.manager.repository.PasswordRepository;
import org.manager.repository.PasswordRepositoryIml;
import org.manager.service.PasswordServiceIml;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        PasswordServiceIml passwordService = new PasswordServiceIml();
        passwordService.addKey();
        passwordService.watchAllPasses();
    }
}
