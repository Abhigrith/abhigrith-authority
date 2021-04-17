package com.example.abhigrith_authority.parent.models;

public class ParentIndividualModel {

    // Properties of model class
    private String fullName;
    // FEMALE represent female and MALE represents male
    private String gender;
    // Format of Date Of Birth is DD-MM-YYYY
    private String dateOfBirth;
    private float income;
    private String aadhaarCardNumber;
    private String panCardNumber;

    // Needed for firebase
    public ParentIndividualModel() {
    }

    public ParentIndividualModel(String fullName, String gender, String dateOfBirth, float income, String aadhaarCardNumber, String panCardNumber) {
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.income = income;
        this.aadhaarCardNumber = aadhaarCardNumber;
        this.panCardNumber = panCardNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public String getAadhaarCardNumber() {
        return aadhaarCardNumber;
    }

    public void setAadhaarCardNumber(String aadhaarCardNumber) {
        this.aadhaarCardNumber = aadhaarCardNumber;
    }

    public String getPanCardNumber() {
        return panCardNumber;
    }

    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }
}
