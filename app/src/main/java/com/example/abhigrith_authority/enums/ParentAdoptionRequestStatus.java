package com.example.abhigrith_authority.enums;

public enum ParentAdoptionRequestStatus {

    PENDING("Pending"), ACCEPTED("Accepted"), REJECTED("Rejected");

    private String adoptionStatus;

    ParentAdoptionRequestStatus(String adoptionStatus){
        this.adoptionStatus = adoptionStatus;
    }

    public String getAdoptionStatus(){
        return this.adoptionStatus;
    }
}

