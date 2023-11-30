package org.manager.app;

import org.manager.service.PasswordServiceIml;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordServiceIml passwordService = new PasswordServiceIml();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        while (true) {
            System.out.println("чтобы добавить новый пароль введите 1\nЧтобы посмотреть всю информацию введите 2\nДля выхода введите exit");
            String userInput = sc.nextLine();
            switch (userInput) {
                case "exit":
                    flag = true;
                    break;
                case "1":
                    passwordService.addKey();
                    System.out.println();
                    break;
                case "2":
                    passwordService.watchAllPasses();
                    System.out.println();
                    break;
            }
            if (flag) {
                break;
            }

        }
    }
}
