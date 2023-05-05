package com.assignment.realestate.controller;

import com.assignment.realestate.entity.location.Country;
import com.assignment.realestate.service.CountryService;
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

import java.util.List;

@RequestMapping("/api/v1/country")
@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    @Operation(summary = "Get all countries", description = "Get all countries", tags = {"country"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Countries fetched successfully")
    })
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/name/{countryName}")
    @Operation(summary = "Get countries by name", description = "Get a country by name", tags = {"country"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Countries fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Countries not found")
    })
    public List<Country> getCountriesByName(@PathVariable @Parameter(name = "countryName", required = true, example = "Sweden", in = ParameterIn.PATH) String countryName) {
        return countryService.getCountryByName(countryName);
    }

    @GetMapping("/{countryId}")
    @Operation(summary = "Get a country by id", description = "Get a country by id", tags = {"country"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Country fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Country not found")
    })
    public Country getCountryById(@PathVariable @Parameter(name = "countryId", required = true, example = "1", in = ParameterIn.PATH) Integer countryId) {
        return countryService.getCountryById(countryId);
    }
}
