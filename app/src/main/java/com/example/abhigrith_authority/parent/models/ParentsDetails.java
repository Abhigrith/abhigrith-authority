package com.example.abhigrith_authority.parent.models;

public class ParentsDetails {

    // Properties of model class
    private boolean isCouple;
    private IndividualParentDetails firstParent;
    private IndividualParentDetails secondParent;
    private String detailedHomeAddress;
    private int pincode;
    private String city;
    private String district;
    private String state;
    private boolean isEligibleToAdopt;

    public ParentsDetails(boolean isCouple, IndividualParentDetails firstParent, IndividualParentDetails secondParent, String detailedHomeAddress, int pincode, String city, String district, String state, boolean isEligibleToAdopt) {
        this.isCouple = isCouple;
        this.firstParent = firstParent;
        this.secondParent = secondParent;
        this.detailedHomeAddress = detailedHomeAddress;
        this.pincode = pincode;
        this.city = city;
        this.district = district;
        this.state = state;
        this.isEligibleToAdopt = isEligibleToAdopt;
    }

    // Getter and Setter Methods Declared for above class properties

    public boolean isCouple() {
        return isCouple;
    }

    public void setCouple(boolean couple) {
        isCouple = couple;
    }

    public IndividualParentDetails getFirstParent() {
        return firstParent;
    }

    public void setFirstParent(IndividualParentDetails firstParent) {
        this.firstParent = firstParent;
    }

    public IndividualParentDetails getSecondParent() {
        return secondParent;
    }

    public void setSecondParent(IndividualParentDetails secondParent) {
        this.secondParent = secondParent;
    }

    public String getDetailedHomeAddress() {
        return detailedHomeAddress;
    }

    public void setDetailedHomeAddress(String detailedHomeAddress) {
        this.detailedHomeAddress = detailedHomeAddress;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isEligibleToAdopt() {
        return isEligibleToAdopt;
    }

    public void setEligibleToAdopt(boolean eligibleToAdopt) {
        isEligibleToAdopt = eligibleToAdopt;
    }
}
