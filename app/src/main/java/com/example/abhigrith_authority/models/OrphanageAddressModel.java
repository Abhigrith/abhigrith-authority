package com.example.abhigrith_authority.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.jetbrains.annotations.NotNull;

public class OrphanageAddressModel implements Parcelable {
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

    protected OrphanageAddressModel(Parcel in) {
        addressOne = in.readString();
        addressTwo = in.readString();
        city = in.readString();
        district = in.readString();
        pincode = in.readString();
        state = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(addressOne);
        dest.writeString(addressTwo);
        dest.writeString(city);
        dest.writeString(district);
        dest.writeString(pincode);
        dest.writeString(state);
    }

    public static final Creator<OrphanageAddressModel> CREATOR = new Creator<OrphanageAddressModel>() {
        @Override
        public OrphanageAddressModel createFromParcel(Parcel in) {
            return new OrphanageAddressModel(in);
        }

        @Override
        public OrphanageAddressModel[] newArray(int size) {
            return new OrphanageAddressModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public @NotNull String toString() {
        return "OrphanageAddressModel{" +
                "addressOne='" + addressOne + '\'' +
                ", addressTwo='" + addressTwo + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", pincode='" + pincode + '\'' +
                ", state='" + state + '\'' +
                '}';
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
