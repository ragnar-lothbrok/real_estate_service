package com.assignment.realestate.service.impl;

import com.assignment.realestate.dto.SearchRequest;
import com.assignment.realestate.entity.estates.*;
import com.assignment.realestate.entity.location.City;
import com.assignment.realestate.repo.ApartmentRepository;
import com.assignment.realestate.repo.PinCodeRepository;
import com.assignment.realestate.repo.UserOwnsApartmentRepository;
import com.assignment.realestate.service.ApartmentService;
import com.assignment.realestate.service.BuildingService;
import com.assignment.realestate.service.UserService;
import com.assignment.realestate.threadlocal.ContextHolder;
import com.assignment.realestate.utils.MapperUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private PinCodeRepository pinCodeRepository;

    @Autowired
    private UserOwnsApartmentRepository userOwnsApartmentRepository;

    @Autowired
    private UserService userService;

    @Override
    public Apartment updateApartment(Integer apartmentId, Apartment apartment) {
        return MapperUtil.fromApartment(apartmentRepository.save(apartment));
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public Apartment createApartment(Apartment apartment) {
        apartment = apartmentRepository.save(apartment);
        UserOwnsApartment userOwnsApartment = new UserOwnsApartment();
        userOwnsApartment.setUserApartmentId(new UserApartmentId().setApartment(apartment).setRealEstateUser(userService.getUserById(ContextHolder.getUserId())));
        userOwnsApartmentRepository.save(userOwnsApartment);
        return MapperUtil.fromApartment(apartment);
    }

    @Override
    public Apartment getApartmentById(int id) {
        return MapperUtil.fromApartment(apartmentRepository.findById(id).get());
    }

    @Override
    public List<Apartment> getApartmentByName(String name) {
        return MapperUtil.fromApartments(apartmentRepository.findByApartmentNameContaining(name));
    }

    @Override
    public List<Apartment> getAllApartments() {
        return MapperUtil.fromApartments(apartmentRepository.findAll());
    }

    @Override
    public List<Apartment> getApartmentByCityAndPropertyTypeAndListingTypeAndPriceRangeAndAreaRangeAndBedroomsAndBathroomsAndParkingAndFurnishedAndPetsAllowedAndAvailableFromAndAvailableTillAndFloorAndTotalFloorsAndAgeOfConstructionAndElevatorAndBalconyAndGardenAndTerraceAndPinCode(City city, PropertyType propertyType, ListingType listingType, Double maxPrice, Double minPrice, Double maxArea, Double minArea, int bedrooms, int bathrooms, int parking, boolean furnished, boolean petsAllowed, int floor, int totalFloors, int propertyAgeInYears, boolean elevator, boolean balcony, boolean garden, boolean terrace, String pinCode) {
        return null;
    }

    @Override
    public List<Apartment> getApartmentsByBuildingId(Integer buildingId) {
        return MapperUtil.fromApartments(apartmentRepository.findByBuilding(buildingService.getBuildingById(buildingId)));
    }

    @Override
    public List<Apartment> getApartmentByPinCode(String pincodeId) {
        return MapperUtil.fromApartments(apartmentRepository.findByPinCode(pinCodeRepository.getOne(pincodeId)));
    }

    @Override
    public Apartment deleteApartment(Integer apartmentId) {
        Apartment apartment = getApartmentById(apartmentId);
        apartmentRepository.deleteById(apartmentId);
        return MapperUtil.fromApartment(apartment);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public List<Apartment> searchApartment(SearchRequest searchRequest) {
        return getAllApartments().stream().filter(apartment -> filter(searchRequest, apartment)).collect(Collectors.toList());
    }

    private boolean filter(SearchRequest searchRequest, Apartment apartment) {
        if(StringUtils.isEmpty(searchRequest.getListingType()) || "ALL".equalsIgnoreCase(searchRequest.getListingType())) {

        } else if(!apartment.getListingType().name().equalsIgnoreCase(searchRequest.getListingType())) {
            return false;
        }
        if(StringUtils.isEmpty(searchRequest.getPropertyType()) || "ALL".equalsIgnoreCase(searchRequest.getPropertyType())) {

        } else if(!apartment.getPropertyType().name().equalsIgnoreCase(searchRequest.getPropertyType())) {
            return false;
        }
        if(StringUtils.isEmpty(searchRequest.getPincode())) {

        } else if(!apartment.getPinCode().getPin().equalsIgnoreCase(searchRequest.getPincode().trim())) {
            return false;
        }
        if(Objects.nonNull(searchRequest.getBuildingId()) && ( Objects.isNull(apartment.getBuilding()) || apartment.getBuilding().getBuildingId().intValue() != searchRequest.getBuildingId().intValue())) {
            return false;
        }
        if(Objects.nonNull(searchRequest.getSocietyId()) && (Objects.isNull(apartment.getBuilding()) || Objects.isNull(apartment.getBuilding().getSociety()) || apartment.getBuilding().getSociety().getSocietyId().intValue() != searchRequest.getSocietyId().intValue())) {
            return false;
        }
        return true;
    }
}
