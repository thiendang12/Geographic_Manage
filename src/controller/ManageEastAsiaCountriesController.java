package controller;

import model.EastAsiaCountries;
import view.MenuView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class ManageEastAsiaCountriesController {

    private ArrayList<EastAsiaCountries> countriesList;
    private MenuView menuView;
    private Scanner scanner;

    public ManageEastAsiaCountriesController() {
        countriesList = new ArrayList<>();
        menuView = new MenuView();
        scanner = new Scanner(System.in);
    }

    public void runApplication() {
        int choice;

        do {
            choice = menuView.displayMenu();

            switch (choice) {
                case 1:
                    addCountryInformation();
                    break;
                case 2:
                    displayRecentlyEnteredInformation();
                    break;
                case 3:
                    searchInformationByName();
                    break;
                case 4:
                    sortInformationByAscendingOrder();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        menuView.closeScanner();
    }

public void addCountryInformation() {
    String code, name, terrain;
    float totalArea;

    // Nhập mã quốc gia và kiểm tra
    do {
        System.out.print("Enter code of country (uppercase letters only): ");
        code = menuView.promptForCountryInfo("");
        if (!code.matches("[A-Z]+")) {
            System.out.println("Invalid input. Please enter uppercase letters only.");
        }
    } while (!code.matches("[A-Z]+"));

    // Nhập tên quốc gia và kiểm tra
    // Nhập tên quốc gia và kiểm tra
do {
    System.out.print("Enter name of country (uppercase initial, spaces allowed, no numbers): ");
    name = scanner.nextLine().trim(); // Sử dụng trim() để loại bỏ khoảng trắng đầu và cuối
    if (!name.matches("^[A-Z][A-Za-z\\s]*") || name.matches(".*\\d.*")) {
        System.out.println("Invalid input. Please follow the format: Uppercase initial, no numbers.");
    }
} while (!name.matches("^[A-Z][A-Za-z\\s]*") || name.matches(".*\\d.*"));

    // Nhập diện tích và kiểm tra
    do {
        System.out.print("Enter total Area (numbers only): ");
        try {
            totalArea = Float.parseFloat(menuView.promptForCountryInfo(""));
            if (totalArea <= 0) {
                System.out.println("Total area must be greater than 0.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numbers only.");
            totalArea = -1; // Đặt giá trị sai để yêu cầu nhập lại
        }
    } while (totalArea <= 0);

    // Nhập đặc điểm địa hình
    System.out.print("Enter terrain of country: ");
    terrain = menuView.promptForCountryInfo("");

    EastAsiaCountries country = new EastAsiaCountries(code, name, totalArea, terrain);
    countriesList.add(country);
    System.out.println("Country information added successfully.");
}


    public void displayRecentlyEnteredInformation() {
        if (countriesList.isEmpty()) {
            System.out.println("No country information has been entered yet.");
            return;
        }

        EastAsiaCountries recentCountry = countriesList.get(countriesList.size() - 1);
        recentCountry.display();
    }

    public void searchInformationByName() {
        String nameToSearch = menuView.promptForCountryInfo("Enter the name you want to search for");

        ArrayList<EastAsiaCountries> searchResults = new ArrayList<>();
        for (EastAsiaCountries country : countriesList) {
            if (country.getCountryName().equalsIgnoreCase(nameToSearch)) {
                searchResults.add(country);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No matching country found.");
        } else {
            System.out.println("Search Results:");
            for (EastAsiaCountries result : searchResults) {
                result.display();
            }
        }
    }

    public void sortInformationByAscendingOrder() {
        if (countriesList.isEmpty()) {
            System.out.println("No country information has been entered yet.");
            return;
        }

        ArrayList<EastAsiaCountries> sortedCountries = new ArrayList<>(countriesList);
        Collections.sort(sortedCountries, Comparator.comparing(EastAsiaCountries::getCountryName));

        System.out.println("Countries sorted in ascending order by name:");
        for (EastAsiaCountries country : sortedCountries) {
            country.display();
        }
    }
}
