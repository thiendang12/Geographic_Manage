package view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView() {
        scanner = new Scanner(System.in);
    }

    public int displayMenu() {
        System.out.println("MENU");
        System.out.println("========================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public String promptForCountryInfo(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.next();
    }

    public void closeScanner() {
        scanner.close();
    }
}
