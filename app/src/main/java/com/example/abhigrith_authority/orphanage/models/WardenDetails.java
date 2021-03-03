package com.example.abhigrith_authority.orphanage.models;

public class WardenDetails {

    // Properties of model class
    private String firstNameOfWarden;
    private String lastNameOfWarden;
    // false represent female and true represents male
    private String genderOfWarden;
    private String dateOfBirth;
    private int ageOfWarden;
    private float incomeOfWarden;
    private String aadhaarCardNumberOfWarden;
    private String panCardNumberOfWarden;

    // Constructor for this model class

    public WardenDetails(String firstNameOfWarden, String lastNameOfWarden, String genderOfWarden, String dateOfBirth, int ageOfWarden, float incomeOfWarden, String aadhaarCardNumberOfWarden, String panCardNumberOfWarden) {
        this.firstNameOfWarden = firstNameOfWarden;
        this.lastNameOfWarden = lastNameOfWarden;
        this.genderOfWarden = genderOfWarden;
        this.dateOfBirth = dateOfBirth;
        this.ageOfWarden = ageOfWarden;
        this.incomeOfWarden = incomeOfWarden;
        this.aadhaarCardNumberOfWarden = aadhaarCardNumberOfWarden;
        this.panCardNumberOfWarden = panCardNumberOfWarden;
    }

    public String getFirstNameOfWarden() {
        return firstNameOfWarden;
    }

    public void setFirstNameOfWarden(String firstNameOfWarden) {
        this.firstNameOfWarden = firstNameOfWarden;
    }

    public String getLastNameOfWarden() {
        return lastNameOfWarden;
    }

    public void setLastNameOfWarden(String lastNameOfWarden) {
        this.lastNameOfWarden = lastNameOfWarden;
    }

    public String isGenderOfWarden() {
        return genderOfWarden;
    }

    public void setGenderOfWarden(String genderOfWarden) {
        this.genderOfWarden = genderOfWarden;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAgeOfWarden() {
        return ageOfWarden;
    }

    public void setAgeOfWarden(int ageOfWarden) {
        this.ageOfWarden = ageOfWarden;
    }

    public float getIncomeOfWarden() {
        return incomeOfWarden;
    }

    public void setIncomeOfWarden(float incomeOfWarden) {
        this.incomeOfWarden = incomeOfWarden;
    }

    public String getAadhaarCardNumberOfWarden() {
        return aadhaarCardNumberOfWarden;
    }

    public void setAadhaarCardNumberOfWarden(String aadhaarCardNumberOfWarden) {
        this.aadhaarCardNumberOfWarden = aadhaarCardNumberOfWarden;
    }

    public String getPanCardNumberOfWarden() {
        return panCardNumberOfWarden;
    }

    public void setPanCardNumberOfWarden(String panCardNumberOfWarden) {
        this.panCardNumberOfWarden = panCardNumberOfWarden;
    }
}
