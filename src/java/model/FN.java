package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FN {

    String name;
    Gender gender;
    List<String> origin;
    List<String> meaning;

    public FN() {
    }

    public FN(String[] parts) {
        this(parts[0], parts[1], parts[2], parts[3]) ;
    }

    public FN(String name, String gender, String origin, String meaning) {
        this.name = name;
        this.gender = Gender.valueOf(gender);
        this.origin = Arrays.asList(origin.split("-"));
        this.meaning = Arrays.asList(meaning.split(","));
    }

    private List<String> makeFromOrigin(String origin) {
        List<String> originList = new ArrayList<>();
        originList.add(origin);
        return originList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<String> getOrigin() {
        return origin;
    }

    public void setOrigin(List<String> origin) {
        this.origin = origin;
    }

    public List<String> getMeaning() {
        return meaning;
    }

    public void setMeaning(List<String> meaning) {
        this.meaning = meaning;
    }
}
