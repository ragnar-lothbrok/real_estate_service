package com.assignment.realestate.service.impl;

import com.assignment.realestate.entity.estates.Amenities;
import com.assignment.realestate.entity.estates.Apartment;
import com.assignment.realestate.service.AmenityService;
import com.assignment.realestate.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenityServiceImpl implements AmenityService {

    @Autowired
    private ApartmentService apartmentService;

    @Override
    public Apartment updateApartmentAmenities(Integer apartmentId, List<Amenities> amenities) {
        Apartment apartment = apartmentService.getApartmentById(apartmentId).setAmenities(amenities);
        return apartmentService.updateApartment(apartment.getApartmentId(), apartment);
    }

}
