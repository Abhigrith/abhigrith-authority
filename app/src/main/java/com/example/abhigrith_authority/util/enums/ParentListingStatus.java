package com.example.abhigrith_authority.util.enums;

public enum ParentListingStatus {

    ACCEPTED("Accepted"), PENDING("Pending"), REJECTED("Rejected");

    private String orphangeListingStatus;

    ParentListingStatus(String orphangeListingStatus) {
        this.orphangeListingStatus = orphangeListingStatus;
    }

    public String getOrphangeListingStatus() {
        return this.orphangeListingStatus;
    }

}
