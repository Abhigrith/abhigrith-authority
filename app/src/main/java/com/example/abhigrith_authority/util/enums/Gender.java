package com.example.abhigrith_authority.util.enums;

public enum Gender {
    MALE("Male"), FEMALE("Female"), Others("Others");

    private String gender;

    Gender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return this.gender;
    }
}
