package util;


import model.Gender;

public class Scanner {

    private java.util.Scanner getScanner() {
        return new java.util.Scanner(System.in);
    }

    public String strScanner(String text) {
        System.out.println(text);
        return getScanner().nextLine();
    }

    public int intScanner(String text) {
        System.out.println(text);
        return getScanner().nextInt();
    }

    public Character characterScanner(String text) {
        System.out.println(text);
        return getScanner().next().charAt(0);
    }

    public Gender genderScanner(String text) {
        System.out.println(text);
        return Gender.valueOf(getScanner().nextLine().toUpperCase());
    }
}
