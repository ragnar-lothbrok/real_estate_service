package com.assignment.realestate.service;

import com.assignment.realestate.dto.SearchRequest;
import com.assignment.realestate.entity.estates.Building;
import com.assignment.realestate.entity.estates.Society;

import java.util.List;

public interface SocietyService {

    Society updateSociety(Integer societyId, Society society);

    Society createSociety(Society society);

    Society getSocietyById(int id);

    List<Society> getSocietyByPincode(String pinCode);

    List<Society> getSocietyByName(String name);

    List<Society> getAllSociety();

    Society deleteSociety(Integer societyId);


    List<Society> searchSociety(SearchRequest searchRequest);
}
