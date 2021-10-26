package com.example.abhigrith_authority.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ParentIndividualModel implements Parcelable {

    // Properties of model class
    private String fullName;
    // FEMALE represent female and MALE represents male
    private String gender;
    // Format of Date Of Birth is DD-MM-YYYY
    private String dateOfBirth;
    private float income;
    private String aadhaarCardNumber;
    private String panCardNumber;

    // Needed for firebase
    public ParentIndividualModel() {
    }

    public ParentIndividualModel(String fullName, String gender, String dateOfBirth, float income, String aadhaarCardNumber, String panCardNumber) {
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.income = income;
        this.aadhaarCardNumber = aadhaarCardNumber;
        this.panCardNumber = panCardNumber;
    }

    protected ParentIndividualModel(Parcel in) {
        fullName = in.readString();
        gender = in.readString();
        dateOfBirth = in.readString();
        income = in.readFloat();
        aadhaarCardNumber = in.readString();
        panCardNumber = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeString(gender);
        dest.writeString(dateOfBirth);
        dest.writeFloat(income);
        dest.writeString(aadhaarCardNumber);
        dest.writeString(panCardNumber);
    }

    public static final Creator<ParentIndividualModel> CREATOR = new Creator<ParentIndividualModel>() {
        @Override
        public ParentIndividualModel createFromParcel(Parcel in) {
            return new ParentIndividualModel(in);
        }

        @Override
        public ParentIndividualModel[] newArray(int size) {
            return new ParentIndividualModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "ParentIndividualModel{" +
                "fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", income=" + income +
                ", aadhaarCardNumber='" + aadhaarCardNumber + '\'' +
                ", panCardNumber='" + panCardNumber + '\'' +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public String getAadhaarCardNumber() {
        return aadhaarCardNumber;
    }

    public void setAadhaarCardNumber(String aadhaarCardNumber) {
        this.aadhaarCardNumber = aadhaarCardNumber;
    }

    public String getPanCardNumber() {
        return panCardNumber;
    }

    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }
}
