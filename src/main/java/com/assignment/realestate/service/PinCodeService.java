package com.assignment.realestate.service;

import com.assignment.realestate.entity.location.Country;
import com.assignment.realestate.entity.location.PinCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PinCodeService {

    PinCode findByCountryAndPinCode(Integer countryId, String pincode);
}
