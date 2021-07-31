package model;

public enum Gender {

    MALE("FÉRFI"),
    FEMALE("NŐI"),
    NO_SUCH_INFO("N/A");

    public final String HUN_NAME;

    Gender(String hunName) {
        this.HUN_NAME = hunName;
    }

    public String getHUN_NAME() {
        return HUN_NAME.toLowerCase();
    }
}
