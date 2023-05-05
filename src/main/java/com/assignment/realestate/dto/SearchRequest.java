package com.assignment.realestate.dto;

import lombok.Data;

@Data
public class SearchRequest {
    private String listingType;
    private String propertyType;
    private String pincode;
    private Long societyId;
    private Long buildingId;
}
