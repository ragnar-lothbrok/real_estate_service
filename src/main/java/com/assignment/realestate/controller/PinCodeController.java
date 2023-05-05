package com.assignment.realestate.controller;

import com.assignment.realestate.entity.location.PinCode;
import com.assignment.realestate.service.PinCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/pincode")
@RestController
public class PinCodeController {

    @Autowired
    private PinCodeService pinCodeService;

    @GetMapping("/{countryId}/{pincode}")
    @Operation(summary = "Get a pincode by country and pincode", description = "Get a pincode by country and pincode", tags = {"pincode"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pincode fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Pincode not found")
    })
    public PinCode getPinCodeByCountryAndPinCode(@PathVariable @Parameter(name = "countryId", required = true, example = "1", in = ParameterIn.PATH) Integer countryId,
                                                 @PathVariable @Parameter(name = "pincode", required = true, example = "12345", in = ParameterIn.PATH) String pincode) {
        return pinCodeService.findByCountryAndPinCode(countryId, pincode);
    }
}
