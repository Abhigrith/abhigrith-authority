package com.example.abhigrith_authority.parent.models;

public class ParentsDetailModel {

    // Properties of model class
    private ParentIndividualModel firstParent;
    private ParentIndividualModel secondParent;
    private ParentsAddressModel address;
    private String primaryContactNumber;
    private String secondaryContactNumber;
    private String emailAddress;
    private String password;
    private String adoptionRequestStatus;

    // Needed for firebase
    public ParentsDetailModel() {
    }

    public ParentsDetailModel(ParentIndividualModel firstParent, ParentIndividualModel secondParent, ParentsAddressModel address, String primaryContactNumber, String secondaryContactNumber, String emailAddress, String password, String adoptionRequestStatus) {
        this.firstParent = firstParent;
        this.secondParent = secondParent;
        this.address = address;
        this.primaryContactNumber = primaryContactNumber;
        this.secondaryContactNumber = secondaryContactNumber;
        this.emailAddress = emailAddress;
        this.password = password;
        this.adoptionRequestStatus = adoptionRequestStatus;
    }

    public ParentIndividualModel getFirstParent() {
        return firstParent;
    }

    public void setFirstParent(ParentIndividualModel firstParent) {
        this.firstParent = firstParent;
    }

    public ParentIndividualModel getSecondParent() {
        return secondParent;
    }

    public void setSecondParent(ParentIndividualModel secondParent) {
        this.secondParent = secondParent;
    }

    public ParentsAddressModel getAddress() {
        return address;
    }

    public void setAddress(ParentsAddressModel address) {
        this.address = address;
    }

    public String getPrimaryContactNumber() {
        return primaryContactNumber;
    }

    public void setPrimaryContactNumber(String primaryContactNumber) {
        this.primaryContactNumber = primaryContactNumber;
    }

    public String getSecondaryContactNumber() {
        return secondaryContactNumber;
    }

    public void setSecondaryContactNumber(String secondaryContactNumber) {
        this.secondaryContactNumber = secondaryContactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdoptionRequestStatus() {
        return adoptionRequestStatus;
    }

    public void setAdoptionRequestStatus(String adoptionRequestStatus) {
        this.adoptionRequestStatus = adoptionRequestStatus;
    }
}
