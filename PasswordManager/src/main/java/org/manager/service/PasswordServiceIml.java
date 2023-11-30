package org.manager.service;

import org.manager.models.PasswordInfo;
import org.manager.repository.PasswordRepository;
import org.manager.repository.PasswordRepositoryIml;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Scanner;

public class PasswordServiceIml implements PasswordService {
    private final PasswordRepositoryIml passwordRepository;
    private final Scanner sc;
    private static Long id;

    public PasswordServiceIml() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("org.manager");

        this.passwordRepository =
                context.getBean("passwordRepository", PasswordRepositoryIml.class);
        this.sc = new Scanner(System.in);
    }
    @Override
    public void addKey() {
        System.out.println("Введите email");
        String email;
        while (true) {
            email = sc.nextLine();
            if (email.isEmpty()) {
                System.err.println("пустой email");
            } else {
                break;
            }
        }
        System.out.println("Введите password");
        String password;
        while (true) {
            password = sc.nextLine();
            if (password.isEmpty()) {
                System.err.println("пустой password");
            } else {
                break;
            }
        }
        System.out.println("Введите site");
        String site;
        while (true) {
            site = sc.nextLine();
            if (site.isEmpty()) {
                System.err.println("пустой site");
            } else {
                break;
            }
        }
        PasswordInfo info = new PasswordInfo(id, email, password, site);
        try {
            passwordRepository.save(info);
            System.out.println("Информация добавлена в базу данных");
        } catch (DataAccessException e) {
            System.err.println("Такие данные уже есть в таблице");
        }
    }

    @Override
    public void watchAllPasses() {
        List<PasswordInfo> res = passwordRepository.findAll();
        for (PasswordInfo item : res) {
            System.out.println(item);
        }
    }
}
