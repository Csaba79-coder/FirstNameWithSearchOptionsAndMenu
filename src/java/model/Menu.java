package model;


import controller.MenuController;
import util.Scanner;

public class Menu {

    public static boolean quit = false;

    public Menu() {
    }

    public void buildUpMenu() {
        String option = chooseOption();
    }


    String chooseOption() {

        Scanner scanner = new Scanner();
        Character choice;
        boolean isValidInput = false;

        do {
            choice = scanner.characterScanner("Would you like to make an advanced search in file? (Y/N)");
            if (Character.toUpperCase(choice) == Character.toUpperCase('y') || Character.toUpperCase(choice) == Character.toUpperCase('n')) {
                isValidInput = true;
                if (Character.toUpperCase(choice) == Character.toUpperCase('y')) {
                    startMenu();
                } else if (Character.toUpperCase(choice) == Character.toUpperCase('n')) {
                    System.out.println("Good bye! ...");
                    quit = true;
                }
            } else {
                System.out.println("Invalid input, please try again!");
            }
        } while (!isValidInput);
        {
            quit = true;
        }
        return null;
    }

    private void startMenu() {
        System.out.println("Starting menu ...");
        new MenuController().printActions();
        new MenuController().opportunitiesAsFollows();
    }
}
