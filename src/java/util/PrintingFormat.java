package util;

import controller.FirstNameController;
import model.FirstName;

import java.util.List;
import java.util.Set;

public class PrintingFormat {


    public void printFirstNamesMap() {
        for (List<FirstName> firstNameList : FirstNameController.firstNamesMap.values())
            for (FirstName firstName : firstNameList) {
                System.out.println("Name: " + firstName.getFirstName() + ("\n\tgender: " + firstName.getGender().getHUN_NAME().toLowerCase()) +
                        ("\n\torigin: ") + firstName.getOrigin() + ("\n\tmeaning: ") + firstName.getMeaning());
                System.out.println(firstName);
            }
    }

    public void printArrayToString(List<String> stringList) {
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    public void printArrayToChar(List<Character> characterList) {
        for (Character ch : characterList) {
            System.out.println(ch);
        }
    }

    public void printArrayToStringFirstName(List<FirstName> stringList) {
        for (FirstName firstName : stringList) {
            System.out.println(firstName);
        }
    }

    public void printSetFirstName(Set<FirstName> set) {
        for (FirstName firstName : set) {
            System.out.println(firstName);
        }
    }

    public void printSet(Set<String> set) {
        for (String s : set) {
            System.out.println(s);
        }
    }

    public void printSeparation() {
        System.out.println("------------------------------------");
    }
}
