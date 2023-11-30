package org.manager.app;

import org.manager.models.PasswordInfo;
import org.manager.service.PasswordServiceIml;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordServiceIml passwordService = new PasswordServiceIml();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        while (true) {
            System.out.println("чтобы добавить новый пароль введите 1\n" +
                    "Чтобы посмотреть всю информацию введите 2\n" +
                    "Чтобы найти пароли введите 3\n" +
                    "Для выхода введите exit");
            String userInput = sc.nextLine();
            switch (userInput) {
                case "exit":
                    flag = true;
                    break;
                case "1":
                    System.out.println();
                    passwordService.addKey();
                    System.out.println();
                    break;
                case "2":
                    System.out.println();
                    passwordService.watchAllPasses();
                    System.out.println();
                    break;
                case "3":
                    System.out.println();
                    System.out.println("Поиск по сайту-1\nПоиск по почте-2\nПоиск по паролю-3");
                    String userInput1 = sc.nextLine();
                    System.out.println();
                    switch (userInput1) {
                        case "1":
                            System.out.println("Введите название сайта");
                            String searchSite = sc.nextLine();
                            List<PasswordInfo> result = passwordService.findSite(searchSite);
                            System.out.println("результат поиска:\n");
                            for (PasswordInfo item : result) {
                                System.out.println(item);
                            }
                            System.out.println();
                            break;
                        case "2":
                            System.out.println("Введите название email");
                            String searchEmail = sc.nextLine();
                            List<PasswordInfo> resultEmail = passwordService.findEmail(searchEmail);
                            System.out.println("результат поиска:\n");
                            for (PasswordInfo item : resultEmail) {
                                System.out.println(item);
                            }
                            System.out.println();
                            break;
                        case "3":
                            System.out.println("Введите пароль");
                            String searchPassword = sc.nextLine();
                            List<PasswordInfo> resultPass = passwordService.findPass(searchPassword);
                            System.out.println("результат поиска:\n");
                            for (PasswordInfo item : resultPass) {
                                System.out.println(item);
                            }
                            System.out.println();
                            break;
                        default:
                            System.err.println("invalid input");
                            System.out.println();
                            break;
                    }
            }
            if (flag) {
                break;
            }

        }
    }
}
