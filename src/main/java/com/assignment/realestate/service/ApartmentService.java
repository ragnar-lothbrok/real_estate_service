package com.assignment.realestate.service;

import com.assignment.realestate.dto.SearchRequest;
import com.assignment.realestate.entity.estates.*;
import com.assignment.realestate.entity.location.City;

import java.util.List;

public interface ApartmentService {

    Apartment updateApartment(Integer apartmentId, Apartment apartment);

    Apartment createApartment(Apartment apartment);

    Apartment getApartmentById(int id);

    List<Apartment> getApartmentByName(String name);

    List<Apartment> getAllApartments();

    List<Apartment> getApartmentByCityAndPropertyTypeAndListingTypeAndPriceRangeAndAreaRangeAndBedroomsAndBathroomsAndParkingAndFurnishedAndPetsAllowedAndAvailableFromAndAvailableTillAndFloorAndTotalFloorsAndAgeOfConstructionAndElevatorAndBalconyAndGardenAndTerraceAndPinCode(City city, PropertyType propertyType, ListingType listingType, Double maxPrice, Double minPrice, Double maxArea, Double minArea, int bedrooms, int bathrooms, int parking, boolean furnished, boolean petsAllowed, int floor, int totalFloors, int propertyAgeInYears, boolean elevator, boolean balcony, boolean garden, boolean terrace, String pinCode);

    List<Apartment> getApartmentsByBuildingId(Integer buildingId);

    List<Apartment> getApartmentByPinCode(String pincodeId);

    Apartment deleteApartment(Integer apartmentId);

    List<Apartment> searchApartment(SearchRequest searchRequest);
}
