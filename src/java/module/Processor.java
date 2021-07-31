package module;

import controller.FirstNameController;
import model.FirstName;
import model.Menu;
import util.PrintingFormat;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Processor {

    public void run() {

        try {
            FirstNameController firstNameController = new FirstNameController();
            firstNameController.runFirstSecondThird();

        } catch (IOException e) {
            e.printStackTrace();
        }

        FirstNameController firstNameController = new FirstNameController();
        PrintingFormat printingFormat = new PrintingFormat();

        firstNameController.runFourth();
        printingFormat.printSeparation();
        firstNameController.runFifth();
        printingFormat.printSeparation();
        List<Character> characterList = firstNameController.runSixth();
        printingFormat.printArrayToChar(characterList);
        printingFormat.printSeparation();
        int specChar = firstNameController.runSeventh();
        System.out.println(specChar);
        printingFormat.printSeparation();
        firstNameController.runEighth();
        printingFormat.printSeparation();
        List<String> namesHasMostMeaning = firstNameController.runNinth();
        printingFormat.printArrayToString(namesHasMostMeaning);
        printingFormat.printSeparation();
        List<String> manMeaningIsUnknown = firstNameController.runTenth();
        printingFormat.printArrayToString(manMeaningIsUnknown);
        printingFormat.printSeparation();
        List<String> womanMeaningIsUnknown = firstNameController.runEleventh();
        printingFormat.printArrayToString(womanMeaningIsUnknown);
        printingFormat.printSeparation();
        int findLastCharNotSize = firstNameController.runTwelfthA();
        System.out.println(findLastCharNotSize);
        List<FirstName> findLastCharNot = firstNameController.runTwelfthB();
        printingFormat.printArrayToStringFirstName(findLastCharNot);
        printingFormat.printSeparation();
        int findLastCharSize = firstNameController.runThirteenthA();
        System.out.println(findLastCharSize);
        List<FirstName> findLastChar = firstNameController.runThirteenthB();
        printingFormat.printArrayToStringFirstName(findLastChar);
        printingFormat.printSeparation();
        List<String> findNameByParts = firstNameController.runFourteenth();
        printingFormat.printArrayToString(findNameByParts);
        printingFormat.printSeparation();
        Set<FirstName> searchingInTheMeaning = firstNameController.runFifteenth();
        printingFormat.printSetFirstName(searchingInTheMeaning);
        printingFormat.printSeparation();
        List<String> findNameByGenderAndFirstLetter = firstNameController.runSixteenth();
        printingFormat.printArrayToString(findNameByGenderAndFirstLetter);
        printingFormat.printSeparation();
        Set<String> findNamesByOrigin = firstNameController.runSeventeenth();
        printingFormat.printSet(findNamesByOrigin);
        printingFormat.printSeparation();
        System.out.println("All origin: ");
        Set<String> findByAllArgsMeaning = firstNameController.runSeventeenthExtra();
        printingFormat.printSet(findByAllArgsMeaning);
        printingFormat.printSeparation();
        System.out.println("All origin, even if includes any of the origins (first ones have the most origin!): ");
        List<String> findAnyFits = firstNameController.runSeventeenthExtraBonus();
        printingFormat.printArrayToString(findAnyFits);

        new Menu().buildUpMenu();
    }
}
