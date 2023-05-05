package com.assignment.realestate.service;

import com.assignment.realestate.dto.SearchRequest;
import com.assignment.realestate.entity.estates.Apartment;
import com.assignment.realestate.entity.estates.Building;
import com.assignment.realestate.entity.estates.ListingType;
import com.assignment.realestate.entity.estates.PropertyType;
import com.assignment.realestate.entity.location.City;

import java.util.List;

public interface BuildingService {

    Building updateBuilding(Integer buildingId, Building building);

    Building createBuilding(Building building);

    Building getBuildingById(int id);

    List<Building> getBuildingByPinCode(String pinCode);

    List<Building> getAllBuildings();


    List<Building> getBuildingByName(String name);

    Building deleteBuilding(Integer buildingId);

    List<Building> searchBuilding(SearchRequest searchRequest);
}
