package com.example.abhigrith_authority.orphanage.models;

public class OrphanageDetails {

    // Properties of model class
    private String nameOfOrphanage;
    private String nameOfOwnerOfOrphanage;
    private WardenDetails warden;
    private String orphanageFCRANumber;
    private String orphanagePanCard;
    private String detailedOrphanageAddress;
    private int pincode;
    private String city;
    private String district;
    private String state;
    private boolean isEligibleToRegister;

    public OrphanageDetails(String nameOfOrphanage, String nameOfOwnerOfOrphanage, WardenDetails warden, String orphanageFCRANumber, String orphanagePanCard, String detailedOrphanageAddress, int pincode, String city, String district, String state, boolean isEligibleToRegister) {
        this.nameOfOrphanage = nameOfOrphanage;
        this.nameOfOwnerOfOrphanage = nameOfOwnerOfOrphanage;
        this.warden = warden;
        this.orphanageFCRANumber = orphanageFCRANumber;
        this.orphanagePanCard = orphanagePanCard;
        this.detailedOrphanageAddress = detailedOrphanageAddress;
        this.pincode = pincode;
        this.city = city;
        this.district = district;
        this.state = state;
        this.isEligibleToRegister = isEligibleToRegister;
    }


    public String getNameOfOrphanage() {
        return nameOfOrphanage;
    }

    public void setNameOfOrphanage(String nameOfOrphanage) {
        this.nameOfOrphanage = nameOfOrphanage;
    }

    public String getNameOfOwnerOfOrphanage() {
        return nameOfOwnerOfOrphanage;
    }

    public void setNameOfOwnerOfOrphanage(String nameOfOwnerOfOrphanage) {
        this.nameOfOwnerOfOrphanage = nameOfOwnerOfOrphanage;
    }

    public WardenDetails getWarden() {
        return warden;
    }

    public void setWarden(WardenDetails warden) {
        this.warden = warden;
    }

    public String getOrphanageFCRANumber() {
        return orphanageFCRANumber;
    }

    public void setOrphanageFCRANumber(String orphanageFCRANumber) {
        this.orphanageFCRANumber = orphanageFCRANumber;
    }

    public String getOrphanagePanCard() {
        return orphanagePanCard;
    }

    public void setOrphanagePanCard(String orphanagePanCard) {
        this.orphanagePanCard = orphanagePanCard;
    }

    public String getDetailedOrphanageAddress() {
        return detailedOrphanageAddress;
    }

    public void setDetailedOrphanageAddress(String detailedOrphanageAddress) {
        this.detailedOrphanageAddress = detailedOrphanageAddress;
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

    public boolean isEligibleToRegister() {
        return isEligibleToRegister;
    }

    public void setEligibleToRegister(boolean eligibleToRegister) {
        isEligibleToRegister = eligibleToRegister;
    }
}
