package com.assignment.realestate.controller;

import com.assignment.realestate.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/locations")
@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    @Operation(summary = "Get all locations", description = "Get all locations", tags = {"location"})
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Locations fetched successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Locations not found")
    })
    public List<Map<String,String>> getLocations() {
        return locationService.findAllLocations();
    }
}
