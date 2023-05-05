package com.assignment.realestate.service.impl;

import com.assignment.realestate.dto.SearchRequest;
import com.assignment.realestate.entity.estates.Apartment;
import com.assignment.realestate.entity.estates.Building;
import com.assignment.realestate.repo.BuildingRepository;
import com.assignment.realestate.repo.PinCodeRepository;
import com.assignment.realestate.repo.SocietyRepository;
import com.assignment.realestate.service.BuildingService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private PinCodeRepository pinCodeRepository;

    private SocietyRepository societyRepository;

    @Autowired
    private BuildingRepository buildingRepository;


    @Override
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    @Override
    public List<Building> getBuildingByName(String name) {
        return buildingRepository.findByBuildingNameContaining(name);
    }

    @Override
    public Building deleteBuilding(Integer buildingId) {
        Building building = getBuildingById(buildingId);
        buildingRepository.deleteById(buildingId);
        return building;
    }

    @Override
    public List<Building> searchBuilding(SearchRequest searchRequest) {
        return getAllBuildings().stream().filter(building -> filter(searchRequest, building)).collect(Collectors.toList());
    }

    private boolean filter(SearchRequest searchRequest, Building building) {
        if(StringUtils.isEmpty(searchRequest.getPincode())) {

        } else if(!building.getPinCode().getPin().equalsIgnoreCase(searchRequest.getPincode().trim())) {
            return false;
        }
        return true;
    }

    @Override
    public Building updateBuilding(Integer buildingId, Building building) {
        return buildingRepository.save(building);
    }

    @Override
    public Building createBuilding(Building building) {
        return buildingRepository.save(building);
    }

    @Override
    public Building getBuildingById(int buildingId) {
        return buildingRepository.findById(buildingId).orElse(null);
    }

    @Override
    public List<Building> getBuildingByPinCode(String pinCode) {
        return buildingRepository.findByPinCode(pinCodeRepository.getOne(pinCode));
    }
}
