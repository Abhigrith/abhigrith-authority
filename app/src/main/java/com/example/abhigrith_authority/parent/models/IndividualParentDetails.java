package com.example.abhigrith_authority.parent.models;

public class IndividualParentDetails {

    // Properties of model class
    private String firstNameOfParent;
    private String lastNameOfParent;
    // false represent female and true represents male
    private String genderOfParent;
    private String dateOfBirth;
    private int ageOfParent;
    private float incomeOfParent;
    private String aadhaarCardNumberOfParent;
    private String panCardNumberOfParent;

    // Constructor for this model class
    public IndividualParentDetails(String firstNameOfParent, String lastNameOfParent, String genderOfParent, String dateOfBirth, int ageOfParent, float incomeOfParent, String aadhaarCardNumberOfParent, String panCardNumberOfParent) {
        this.firstNameOfParent = firstNameOfParent;
        this.lastNameOfParent = lastNameOfParent;
        this.genderOfParent = genderOfParent;
        this.dateOfBirth = dateOfBirth;
        this.ageOfParent = ageOfParent;
        this.incomeOfParent = incomeOfParent;
        this.aadhaarCardNumberOfParent = aadhaarCardNumberOfParent;
        this.panCardNumberOfParent = panCardNumberOfParent;
    }

    // Getter and Setter Methods Declared for above class properties

    public String getFirstNameOfParent() {
        return firstNameOfParent;
    }

    public void setFirstNameOfParent(String firstNameOfParent) {
        this.firstNameOfParent = firstNameOfParent;
    }

    public String getLastNameOfParent() {
        return lastNameOfParent;
    }

    public void setLastNameOfParent(String lastNameOfParent) {
        this.lastNameOfParent = lastNameOfParent;
    }

    public String isGenderOfParent() {
        return genderOfParent;
    }

    public void setGenderOfParent(String genderOfParent) {
        this.genderOfParent = genderOfParent;
    }

    public int getAgeOfParent() {
        return ageOfParent;
    }

    public void setAgeOfParent(int ageOfParent) {
        this.ageOfParent = ageOfParent;
    }

    public float getIncomeOfParent() {
        return incomeOfParent;
    }

    public void setIncomeOfParent(float incomeOfParent) {
        this.incomeOfParent = incomeOfParent;
    }

    public String getAadhaarCardNumberOfParent() {
        return aadhaarCardNumberOfParent;
    }

    public void setAadhaarCardNumberOfParent(String aadhaarCardNumberOfParent) {
        this.aadhaarCardNumberOfParent = aadhaarCardNumberOfParent;
    }

    public String getPanCardNumberOfParent() {
        return panCardNumberOfParent;
    }

    public void setPanCardNumberOfParent(String panCardNumberOfParent) {
        this.panCardNumberOfParent = panCardNumberOfParent;
    }
}
