package com.assignment.realestate.service;

import com.assignment.realestate.entity.estates.Amenities;
import com.assignment.realestate.entity.estates.Apartment;
import com.assignment.realestate.entity.estates.ListingType;
import com.assignment.realestate.entity.estates.PropertyType;
import com.assignment.realestate.entity.location.City;

import java.util.List;

public interface AmenityService {
    Apartment updateApartmentAmenities(Integer apartmentId, List<Amenities> amenities);

}
