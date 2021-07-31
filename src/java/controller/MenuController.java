package controller;

import model.Gender;
import model.Menu;
import util.PrintingFormat;
import util.Scanner;

public class MenuController {

    public void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("""
                0  - to shut down
                1  - searching meaning by names
                2  - searching origin by names
                3  - which gender belongs the name (answer in Hungarian)
                4  - which gender belongs the name (answer in English)
                5  - find the name by meaning
                6  - please enter a gender, and to find the name that starts with a given character
                7  - to print a list of available actions""");
        System.out.println("Choose your action ... ");
    }

    public void opportunitiesAsFollows() {

        Scanner scanner = new Scanner();
        FirstNameController firstNameController = new FirstNameController();
        PrintingFormat printingFormat = new PrintingFormat();

        while (!Menu.quit) {
            int action = scanner.intScanner("Please enter an action: ");
            switch (action) {
                case 0 -> {
                    System.out.println("Good bye!\nShutting down ...");
                    Menu.quit = true;
                }
                case 1 -> {
                    String name1 = scanner.strScanner("Please enter a name: ");
                    System.out.println("The meaning of the name is: ");
                    printingFormat.printArrayToString(firstNameController.meaningOfYourName(name1));
                }
                case 2 -> {
                    String name2 = scanner.strScanner("Please enter a name: ");
                    printingFormat.printArrayToString(firstNameController.findOriginByName(name2));
                }
                case 3 -> {
                    String name3 = scanner.strScanner("Please enter a name: ");
                    String nameCap3 = name3.substring(0, 1).toUpperCase() + name3.substring(1).toLowerCase();
                    System.out.println(nameCap3 + " az alábbi nemhez tartozik: ");
                    System.out.println(firstNameController.searchGenderByNameHungarian(name3));
                }
                case 4 -> {
                    String name4 = scanner.strScanner("Please enter a name: ");
                    String nameCap4 = name4.substring(0, 1).toUpperCase() + name4.substring(1).toLowerCase();
                    System.out.println("The name " + nameCap4 + " belongs to the following gender: ");
                    System.out.println(firstNameController.searchGenderByNameEnglish(name4));
                }
                case 5 -> {
                    String meaning = scanner.strScanner("Please give a possible name meaning in Hungarian: ");
                    printingFormat.printArrayToStringFirstName(firstNameController.searchByMeaning(meaning));
                }
                case 6 -> {
                    Gender gender = scanner.genderScanner("Please enter a gender (MALE or FEMALE): ");
                    Character firstChar = scanner.characterScanner("Please enter a char that the name starts with: ");
                    printingFormat.printArrayToStringFirstName(firstNameController.findNameByGender(gender, firstChar));
                }
                case 7 -> printActions();
            }
        }
    }
}







