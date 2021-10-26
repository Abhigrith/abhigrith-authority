package com.example.abhigrith_authority.models;

import android.os.Parcel;
import android.os.Parcelable;

public class OrphanageModel implements Parcelable {

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

    protected OrphanageModel(Parcel in) {
        orphanageId = in.readString();
        orphanageName = in.readString();
        orphanageAddress = in.readParcelable(OrphanageAddressModel.class.getClassLoader());
        orphanagePrimaryPhoneNumber = in.readString();
        orphanageSecondaryPhoneNumber = in.readString();
        orphanageEmail = in.readString();
        orphanagePassword = in.readString();
        orphanageListingStatus = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(orphanageId);
        dest.writeString(orphanageName);
        dest.writeParcelable(orphanageAddress, flags);
        dest.writeString(orphanagePrimaryPhoneNumber);
        dest.writeString(orphanageSecondaryPhoneNumber);
        dest.writeString(orphanageEmail);
        dest.writeString(orphanagePassword);
        dest.writeString(orphanageListingStatus);
    }

    public static final Creator<OrphanageModel> CREATOR = new Creator<OrphanageModel>() {
        @Override
        public OrphanageModel createFromParcel(Parcel in) {
            return new OrphanageModel(in);
        }

        @Override
        public OrphanageModel[] newArray(int size) {
            return new OrphanageModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
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
