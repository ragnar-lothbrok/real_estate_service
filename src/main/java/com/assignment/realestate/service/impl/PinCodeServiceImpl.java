package com.assignment.realestate.service.impl;

import com.assignment.realestate.entity.location.PinCode;
import com.assignment.realestate.repo.PinCodeRepository;
import com.assignment.realestate.service.CountryService;
import com.assignment.realestate.service.PinCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinCodeServiceImpl implements PinCodeService {

    @Autowired
    private PinCodeRepository pinCodeRepository;

    @Autowired
    private CountryService countryService;

    @Override
    public PinCode findByCountryAndPinCode(Integer countryId, String pincode) {
        return pinCodeRepository.findByCountryAndPin(countryService.getCountryById(countryId), pincode).orElse(null);
    }
}
