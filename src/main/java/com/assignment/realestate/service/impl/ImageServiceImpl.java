package com.assignment.realestate.service.impl;

import com.assignment.realestate.entity.estates.Apartment;
import com.assignment.realestate.entity.estates.Images;
import com.assignment.realestate.service.ApartmentService;
import com.assignment.realestate.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ApartmentService apartmentService;

    @Override
    public Apartment updateApartmentImages(Integer apartmentId, List<Images> images) {
        Apartment apartment = apartmentService.getApartmentById(apartmentId).setImages(images);
        return apartmentService.updateApartment(apartment.getApartmentId(), apartment);
    }
}
