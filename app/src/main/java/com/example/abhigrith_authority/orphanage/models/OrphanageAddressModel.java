package com.example.abhigrith_authority.orphanage.models;

public class OrphanageAddressModel {
    private String addressOne;
    private String addressTwo;
    private String city;
    private String district;
    private String pincode;
    private String state;

    // Needed for firebase
    public OrphanageAddressModel() {

    }

    public OrphanageAddressModel(String addressOne, String addressTwo, String city, String district, String pincode, String state) {
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.district = district;
        this.pincode = pincode;
        this.state = state;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
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
