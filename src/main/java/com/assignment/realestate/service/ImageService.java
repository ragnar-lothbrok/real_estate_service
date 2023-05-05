package com.assignment.realestate.service;

import com.assignment.realestate.entity.estates.Amenities;
import com.assignment.realestate.entity.estates.Apartment;
import com.assignment.realestate.entity.estates.Images;

import java.util.List;

public interface ImageService {
    Apartment updateApartmentImages(Integer apartmentId, List<Images> images);

}
