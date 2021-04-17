package com.example.abhigrith_authority.orphanage.models;

import org.jetbrains.annotations.NotNull;

public class OrphanageModel {

    private String orphanageId;
    private String orphanageName;
    private OrphanageAddressModel orphanageAddress;
    private String orphanagePrimaryPhoneNumber;
    private String orphanageSecondaryPhoneNumber;
    private String orphanageEmail;
    private String orphanagePassword;
    private String orphanageListingStatus;

    // For Firebase
    public OrphanageModel() {

    }

    public OrphanageModel(String orphanageId, String orphanageName, OrphanageAddressModel orphanageAddress, String orphanagePrimaryPhoneNumber, String orphanageSecondaryPhoneNumber, String orphanageEmail, String orphanagePassword, String orphanageListingStatus) {
        this.orphanageId = orphanageId;
        this.orphanageName = orphanageName;
        this.orphanageAddress = orphanageAddress;
        this.orphanagePrimaryPhoneNumber = orphanagePrimaryPhoneNumber;
        this.orphanageSecondaryPhoneNumber = orphanageSecondaryPhoneNumber;
        this.orphanageEmail = orphanageEmail;
        this.orphanagePassword = orphanagePassword;
        this.orphanageListingStatus = orphanageListingStatus;
    }

    @Override
    public @NotNull String toString() {
        return "OrphanageModel{" +
                "orphanageId='" + orphanageId + '\'' +
                ", orphanageName='" + orphanageName + '\'' +
                ", orphanageAddress=" + orphanageAddress +
                ", orphanagePrimaryPhoneNumber='" + orphanagePrimaryPhoneNumber + '\'' +
                ", orphanageSecondaryPhoneNumber='" + orphanageSecondaryPhoneNumber + '\'' +
                ", orphanageEmail='" + orphanageEmail + '\'' +
                ", orphanagePassword='" + orphanagePassword + '\'' +
                ", orphanageListingStatus='" + orphanageListingStatus + '\'' +
                '}';
    }

    public String getOrphanageId() {
        return orphanageId;
    }

    public void setOrphanageId(String orphanageId) {
        this.orphanageId = orphanageId;
    }

    public String getOrphanageName() {
        return orphanageName;
    }

    public void setOrphanageName(String orphanageName) {
        this.orphanageName = orphanageName;
    }

    public OrphanageAddressModel getOrphanageAddress() {
        return orphanageAddress;
    }

    public void setOrphanageAddress(OrphanageAddressModel orphanageAddress) {
        this.orphanageAddress = orphanageAddress;
    }

    public String getOrphanagePrimaryPhoneNumber() {
        return orphanagePrimaryPhoneNumber;
    }

    public void setOrphanagePrimaryPhoneNumber(String orphanagePrimaryPhoneNumber) {
        this.orphanagePrimaryPhoneNumber = orphanagePrimaryPhoneNumber;
    }

    public String getOrphanageSecondaryPhoneNumber() {
        return orphanageSecondaryPhoneNumber;
    }

    public void setOrphanageSecondaryPhoneNumber(String orphanageSecondaryPhoneNumber) {
        this.orphanageSecondaryPhoneNumber = orphanageSecondaryPhoneNumber;
    }

    public String getOrphanageEmail() {
        return orphanageEmail;
    }

    public void setOrphanageEmail(String orphanageEmail) {
        this.orphanageEmail = orphanageEmail;
    }

    public String getOrphanagePassword() {
        return orphanagePassword;
    }

    public void setOrphanagePassword(String orphanagePassword) {
        this.orphanagePassword = orphanagePassword;
    }

    public String getOrphanageListingStatus() {
        return orphanageListingStatus;
    }

    public void setOrphanageListingStatus(String orphanageListingStatus) {
        this.orphanageListingStatus = orphanageListingStatus;
    }
}
