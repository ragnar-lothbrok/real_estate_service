package com.assignment.realestate.service.impl;

import com.assignment.realestate.dto.SearchRequest;
import com.assignment.realestate.entity.estates.Building;
import com.assignment.realestate.entity.estates.Society;
import com.assignment.realestate.repo.PinCodeRepository;
import com.assignment.realestate.repo.SocietyRepository;
import com.assignment.realestate.service.SocietyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocietyServiceImpl implements SocietyService {

    @Autowired
    private SocietyRepository societyRepository;

    @Autowired
    private PinCodeRepository pinCodeRepository;

    @Override
    public Society updateSociety(Integer societyId, Society society) {
        return societyRepository.save(society);
    }

    @Override
    public Society createSociety(Society society) {
        return societyRepository.save(society);
    }

    @Override
    public Society getSocietyById(int id) {
        return societyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Society> getSocietyByPincode(String pinCode) {
        return societyRepository.findByPinCode(pinCodeRepository.getOne(pinCode));
    }

    @Override
    public List<Society> getSocietyByName(String name) {
        return societyRepository.findBySocietyNameContaining(name);
    }

    @Override
    public List<Society> getAllSociety() {
        return societyRepository.findAll();
    }

    @Override
    public Society deleteSociety(Integer societyId) {
        Society society = getSocietyById(societyId);
        societyRepository.deleteById(societyId);
        return society;
    }

    @Override
    public List<Society> searchSociety(SearchRequest searchRequest) {
        return getAllSociety().stream().filter(society -> filter(searchRequest, society)).collect(Collectors.toList());
    }

    private boolean filter(SearchRequest searchRequest, Society society) {
        if(StringUtils.isEmpty(searchRequest.getPincode())) {

        } else if(!society.getPinCode().getPin().equalsIgnoreCase(searchRequest.getPincode().trim())) {
            return false;
        }
        return true;
    }
}
