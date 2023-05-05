package com.assignment.realestate.service.impl;

import com.assignment.realestate.entity.location.Country;
import com.assignment.realestate.repo.CountryRepository;
import com.assignment.realestate.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public List<Country> getCountryByName(String countryName) {
        return countryRepository.findByNameContaining(countryName);
    }

    public Country getCountryById(Integer countryId) {
        return countryRepository.findById(countryId).orElse(null);
    }
}
