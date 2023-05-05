package com.assignment.realestate.service;

import com.assignment.realestate.entity.location.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {
    List<Country> getAllCountries();

    List<Country> getCountryByName(String countryName);

    Country getCountryById(Integer countryId);
}
