package com.example.abhigrith_authority.parent.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ParentsDetailModel implements Parcelable {

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

    protected ParentsDetailModel(Parcel in) {
        firstParent = in.readParcelable(ParentIndividualModel.class.getClassLoader());
        secondParent = in.readParcelable(ParentIndividualModel.class.getClassLoader());
        address = in.readParcelable(ParentsAddressModel.class.getClassLoader());
        primaryContactNumber = in.readString();
        secondaryContactNumber = in.readString();
        emailAddress = in.readString();
        password = in.readString();
        adoptionRequestStatus = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(firstParent, flags);
        dest.writeParcelable(secondParent, flags);
        dest.writeParcelable(address, flags);
        dest.writeString(primaryContactNumber);
        dest.writeString(secondaryContactNumber);
        dest.writeString(emailAddress);
        dest.writeString(password);
        dest.writeString(adoptionRequestStatus);
    }

    public static final Creator<ParentsDetailModel> CREATOR = new Creator<ParentsDetailModel>() {
        @Override
        public ParentsDetailModel createFromParcel(Parcel in) {
            return new ParentsDetailModel(in);
        }

        @Override
        public ParentsDetailModel[] newArray(int size) {
            return new ParentsDetailModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "ParentsDetailModel{" +
                "firstParent=" + firstParent +
                ", secondParent=" + secondParent +
                ", address=" + address +
                ", primaryContactNumber='" + primaryContactNumber + '\'' +
                ", secondaryContactNumber='" + secondaryContactNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", adoptionRequestStatus='" + adoptionRequestStatus + '\'' +
                '}';
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
