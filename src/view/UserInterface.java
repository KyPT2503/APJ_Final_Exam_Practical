package view;

import java.util.Scanner;

public class UserInterface {
    private static UserInterface instance;

    Scanner scanner;

    private UserInterface() {
        scanner = new Scanner(System.in);
    }

    public static UserInterface getInstance() {
        if (instance == null) {
            synchronized (UserInterface.class) {
                if (instance == null) {
                    instance = new UserInterface();
                }
            }
        }
        return instance;
    }

    public void displayMainMenu() {
        System.out.println("----PHONE BOOK MANAGER----");
        System.out.println("Choose feature follow the number:");
        System.out.println("1. Display directory");
        System.out.println("2. Add");
        System.out.println("3. Update");
        System.out.println("4. Remove");
        System.out.println("5. Find");
        System.out.println("6. Read from file");
        System.out.println("7. Write to file");
        System.out.println("8. Exit");
        System.out.print("Option: ");
    }
    public void displayMessage(String message){
        System.out.println(message);
    }

    public String getOption() {
        return scanner.nextLine();
    }
}
