package oop.model.enums;

public enum Gender {
    MAN("męzczyzna"), WOMAN("kobieta");

    private final String genderName;
public String getGenderName(){
    return genderName;
}

    Gender(String genderName) {
        this.genderName = genderName;
    }
}