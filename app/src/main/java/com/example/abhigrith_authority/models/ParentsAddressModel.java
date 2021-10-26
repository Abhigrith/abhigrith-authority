package com.example.abhigrith_authority.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ParentsAddressModel implements Parcelable {

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

    protected ParentsAddressModel(Parcel in) {
        primaryAddress = in.readString();
        secondaryAddress = in.readString();
        city = in.readString();
        district = in.readString();
        pincode = in.readString();
        state = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(primaryAddress);
        dest.writeString(secondaryAddress);
        dest.writeString(city);
        dest.writeString(district);
        dest.writeString(pincode);
        dest.writeString(state);
    }

    public static final Creator<ParentsAddressModel> CREATOR = new Creator<ParentsAddressModel>() {
        @Override
        public ParentsAddressModel createFromParcel(Parcel in) {
            return new ParentsAddressModel(in);
        }

        @Override
        public ParentsAddressModel[] newArray(int size) {
            return new ParentsAddressModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "ParentsAddressModel{" +
                "primaryAddress='" + primaryAddress + '\'' +
                ", secondaryAddress='" + secondaryAddress + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", pincode='" + pincode + '\'' +
                ", state='" + state + '\'' +
                '}';
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
