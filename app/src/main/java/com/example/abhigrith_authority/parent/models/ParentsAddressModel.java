package com.example.abhigrith_authority.parent.models;

public class ParentsAddressModel {

    private String primaryAddress;
    private String secondaryAddress;
    private String city;
    private String district;
    private String pincode;
    private String state;

    // Needed for firebase
    public ParentsAddressModel() {
    }

    public ParentsAddressModel(String primaryAddress, String secondaryAddress, String city, String district, String pincode, String state) {
        this.primaryAddress = primaryAddress;
        this.secondaryAddress = secondaryAddress;
        this.city = city;
        this.district = district;
        this.pincode = pincode;
        this.state = state;
    }

    public String getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getSecondaryAddress() {
        return secondaryAddress;
    }

    public void setSecondaryAddress(String secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
