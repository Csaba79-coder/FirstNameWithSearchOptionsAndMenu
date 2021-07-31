package controller;

import model.FirstName;
import model.Gender;
import util.FileHandler;
import util.PrintingFormat;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class FirstNameController {


    public static Map<Gender, List<FirstName>> firstNamesMap = new HashMap<>();
    private static final Map<Character, List<FirstName>> CHARACTER_MAP = new HashMap<>();
    private static final String MY_NAME = "Csaba";
    private static final Object[] ARGS = new Object[]{"héber", "latin", "görög"};
    private static final Object[] ARGS_2 = new Object[]{"héber", "latin"};


    public void runFirstSecondThird() throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.read();
    }

    public void runFourth() {
        PrintingFormat printingFormat = new PrintingFormat();
        printingFormat.printFirstNamesMap();
    }

    public void runFifth() {
        List<String> myNameMeans = meaningOfYourName(MY_NAME);
        PrintingFormat printingFormat = new PrintingFormat();
        printingFormat.printArrayToString(myNameMeans);
    }

    public List<String> meaningOfYourName(String name) {
        List<String> noSuchName = Arrays.asList("There is no such name in our list!", "Sorry!!!");
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getFirstName().equalsIgnoreCase(name))
                    return firstName.getMeaning();
            }
        }
        return noSuchName;
    }

    public List<Character> runSixth() {
        return getTheMostPopularInitial(CHARACTER_MAP);
    }

    private int findMaxChar() {
        int max = 0;

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                CHARACTER_MAP.putIfAbsent(firstName.getFirstName().charAt(0), new ArrayList<>());
                CHARACTER_MAP.get(firstName.getFirstName().charAt(0)).add(firstName);
                for (Map.Entry<Character, List<FirstName>> entry : CHARACTER_MAP.entrySet()) {
                    if (entry.getValue().size() > max) {
                        max = entry.getValue().size();
                    }
                }
            }
        }
        return max;
    }

    private List<Character> getTheMostPopularInitial(Map<Character , List<FirstName>> characterListMap){
        List<Character> theMostPopularInitial = new ArrayList<>();
        int counter = findMaxChar();

        for (Character key : characterListMap.keySet()) {
            if(characterListMap.get(key).size() == counter){
                theMostPopularInitial.add(key);
            }
        }
        return theMostPopularInitial;
    }

    public int runSeventh() {
        String character = "e";
        int num;
        num = countTheNamesStartingWith(firstNamesMap, character);
        return num;
    }

    private int countTheNamesStartingWith(Map<Gender, List<FirstName>> firstNamesMap, String character) {
        List<String> tempList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (character.toUpperCase().equals(String.valueOf(firstName.getFirstName().charAt(0)))) {
                    tempList.add(firstName.getFirstName());
                }
            }
        }
        return tempList.size();
    }

    public void runEighth() {
        String rate = rateOfManWomanNamesByGender();
        System.out.println(rate);
    }

    private String rateOfManWomanNamesByGender() {
        float rateOfMale = rateOfMaleNames();
        // float rateOfFemale = 100 - rateOfMale;
        int rateMale = (int) rateOfMale;
        int rateOfFem = 100 - rateMale;

        return (rateMale + " : " + rateOfFem);
    }

    private float rateOfMaleNames() {
        float sum = sumNames();
        float sumMale = sumMaleNames();
        return (sumMale / sum) * 100;
    }

    private int sumNames() {
        List<String> tempList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (Gender.MALE.equals(firstName.getGender()) || Gender.FEMALE.equals(firstName.getGender())) {
                    tempList.add(firstName.getFirstName());
                }
            }
        }
        return tempList.size();
    }

    private int sumMaleNames() {
        List<String> tempList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (Gender.MALE.equals(firstName.getGender())) {
                    tempList.add(firstName.getFirstName());
                }
            }
        }
        return tempList.size(); // == counter!!!
    }

    public List<String> runNinth() {
        return findMaxMeaningOfNames();
    }

    private List<String> findMaxMeaningOfNames() {
        int max = findMaxMeaning();
        List<String> firstNameHasMoreMeaning = new ArrayList<>();
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (max == firstName.getMeaning().size()) {
                    firstNameHasMoreMeaning.add(firstName.getFirstName());
                }
            }
        }
        return firstNameHasMoreMeaning;
    }

    private int findMaxMeaning() {
        int max = 0;

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getMeaning().size() > max) {
                    max = firstName.getMeaning().size();
                }
            }
        }
        return max;
    }

    public List<String> runTenth() {
        return findNamesMeaningIsUnknownMale();
    }

    public List<String> runEleventh() {
        return findNamesMeaningIsUnknownFemale();
    }

    private List<String> findNamesMeaningIsUnknownMale() {
        List<String> tempList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getGender().equals(Gender.MALE) && firstName.getMeaning().get(0).contains("ismeretlen")) {
                    tempList.add(firstName.getFirstName());
                }
            }
        }
        return tempList;
    }

    private List<String> findNamesMeaningIsUnknownFemale() {
        List<String> tempList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getGender().equals(Gender.FEMALE) && firstName.getMeaning().get(0).contains("ismeretlen")) {
                        tempList.add(firstName.getFirstName());
                }
            }
        }
        return tempList;
    }

    public List<FirstName> runThirteenthB() {
        return checkLastChar(Gender.MALE, 'a');
    }

    public int runThirteenthA() {
        return checkLastChar(Gender.MALE, 'a').size();
    }

    private List<FirstName> checkLastChar(Gender gender, Character character) {
        List<FirstName> tempList = new ArrayList<>();
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getGender().equals(gender) && character.equals(firstName.getFirstName().charAt(firstName.getFirstName().length()-1))) {
                    tempList.add(firstName);
                }
            }
        }
        return tempList;
    }

    public List<FirstName> runTwelfthB() {
        return checkLastCharNot(Gender.FEMALE, 'a');
    }

    public int runTwelfthA() {
        return checkLastCharNot(Gender.FEMALE, 'a').size();
    }

    private  List<FirstName> checkLastCharNot(Gender gender, Character character) {
        List<FirstName> tempList = new ArrayList<>();
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getGender().equals(gender) && character != firstName.getFirstName().charAt(firstName.getFirstName().length()-1)) {
                    tempList.add(firstName);
                }
            }
        }
        return tempList;
    }

    public List<String> runFourteenth() {
        return findNameByParts("Anna");
    }

    private List<String> findNameByParts(String part) {
        List<String> nameList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getFirstName().toUpperCase().contains(part.toUpperCase())) {
                    nameList.add(firstName.getFirstName());
                }
            }
        }
        return nameList;
    }

    public Set<FirstName> runFifteenth() {
        return searchingInTheMeaning("kő");
    }

    private Set<FirstName> searchingInTheMeaning(String part) {
        Set<FirstName> nameSet = new HashSet<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (int i = 0; i < firstNamesMap.size(); i++) {
                for (FirstName firstName : firstNameList) {
                    if (iterateOnList(firstName.getMeaning(), part)) {
                        Collections.swap(firstName.getMeaning(), findIndex(firstName.getMeaning(), part), 0);
                        nameSet.add(firstName);
                    }
                }
            }
        }
        return nameSet;
    }

    private boolean iterateOnList(List<String> stringList, String s) {
        for (String string : stringList) {
            if (string.toUpperCase().contains(s.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    private int findIndex(List<String> stringList, String s) {
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).contains(s)) {
                return i;
            }
        }
        return -1;
    }

    public List<String> runSixteenth() {
        return findNameByGenderAndFirstLetter(Gender.FEMALE, 'e');
    }

    private List<String> findNameByGenderAndFirstLetter(Gender gender, Character character) {
        List<String> stringList = new ArrayList<>();
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getGender().equals(gender) && firstName.getFirstName().charAt(0) == Character.toUpperCase(character)) {
                    stringList.add(firstName.getFirstName());
                }
            }
        }
        return stringList;
    }

    public Set<String> runSeventeenth() {
        return findNamesByOrigin("héber");
    }

    private Set<String> findNamesByOrigin(String origin) {
        Set<String> tempList = new HashSet<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (findByOrigin(firstName.getOrigin(), origin)) {
                    tempList.add(firstName.getFirstName());
                }
            }
        }
        return tempList;
    }

    private boolean findByOrigin(List<String> stringList, String origin) {
        for (String s : stringList) {
            if (s.equals(origin)) {
                return true;
            }
        }
        return false;
    }

    public Set<String> runSeventeenthExtra() {
        return findByArgs(ARGS);
    }

    public boolean verifyAllElementsAreEqual(List<String> list, Object[] args) {
        List<String> stringList = new ArrayList<>();
        for (String s : list) {
            for (Object arg : args) {
                if (s.equals(arg)) {
                    stringList.add(s);
                }
                if (stringList.size() == args.length) {
                    return true;
                }
            }
        }
        return false;
    }

    private Set<String> findByArgs(Object[] args) {
        Set<String> stringSet = new HashSet<>();
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (verifyAllElementsAreEqual(firstName.getOrigin(), ARGS)) {
                    stringSet.add(firstName.getFirstName());
                }
            }
        }
        return stringSet;
    }

    public List<String> runSeventeenthExtraBonus(){
        return findAnyFits(ARGS_2);
    }

    private boolean verifyAnyArgs(List<String> stringList, Object[] args) {
        for (Object arg : args) {
            for (String s : stringList) {
                if (arg.equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<String> findAnyFits(Object[] args) {
        List<String> stringList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (verifyAllElementsAreEqual(firstName.getOrigin(), ARGS_2)) {
                    stringList.add(0, firstName.getFirstName());
                } else if (verifyAnyArgs(firstName.getOrigin(), ARGS_2) && ! stringList.contains(firstName.getFirstName())) {
                    stringList.add((firstName.getFirstName()));
                }
            }
        }
        return stringList;
    }

    public List<String> findOriginByName(String name) {
        List<String> tempList = new ArrayList<>();
        tempList.add("There is no such name in file!");
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getFirstName().equalsIgnoreCase(name)) {
                    return firstName.getOrigin();
                }
            }
        }
        return tempList;
    }

    public String searchGenderByNameEnglish(String name) {
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getFirstName().equalsIgnoreCase(name)) {
                    return firstName.getGender().toString().toLowerCase();
                }
            }
        }
        return Gender.NO_SUCH_INFO.toString().toLowerCase();
    }

    public String searchGenderByNameHungarian(String name) {
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getFirstName().equalsIgnoreCase(name)) {
                    return firstName.getGender().getHUN_NAME();
                }
            }
        }
        return Gender.NO_SUCH_INFO.getHUN_NAME().toLowerCase();
    }

    public List<FirstName> searchByMeaning(String meaning) {
        List<FirstName> currFirstNameList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (findInMeaning(firstName.getMeaning(), meaning.toLowerCase())) {
                    currFirstNameList.add(firstName);
                }
            }
        }
        return currFirstNameList;
    }

    private boolean findInMeaning(List<String> stringList, String meaning) {
        for (String s : stringList) {
            if (stringList.contains(meaning)) {
                return true;
            }
        }
        return false;
    }

    public List<FirstName> findNameByGender(Gender gender, Character character) {
        List<FirstName> tempList = new ArrayList<>();

        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (findNameByGenderFirstName(gender, Character.toUpperCase(character))) {
                    if (firstName.getGender().equals(gender) && Character.toUpperCase(firstName.getFirstName().charAt(0)) == Character.toUpperCase(character))
                        tempList.add(firstName);
                }
            }
        }
        return tempList;
    }

    private boolean findNameByGenderFirstName(Gender gender, Character character) {
        for (List<FirstName> firstNameList : firstNamesMap.values()) {
            for (FirstName firstName : firstNameList) {
                if (firstName.getGender().equals(gender) || Character.toUpperCase(firstName.getFirstName().charAt(0)) == Character.toUpperCase(character)) {
                    return true;
                }
            }
        }
        return false;
    }
}