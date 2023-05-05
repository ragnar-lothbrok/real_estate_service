package com.assignment.realestate.controller;

import com.assignment.realestate.dto.SearchRequest;
import com.assignment.realestate.entity.estates.Apartment;
import com.assignment.realestate.service.ApartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("/api/v1/apartment")
@RestController
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping
    @Operation(summary = "Get all apartments", description = "Get all apartments", tags = { "apartment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apartments fetched successfully")
    })
    public List<Apartment> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    @GetMapping("/{apartmentId}")
   @Operation(summary = "Get a apartment by id", description = "Get a apartment by id", tags = { "apartment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apartment fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Apartment not found")
    })
    public Apartment getApartmentById(@PathVariable @Parameter(name = "apartmentId", required = true, example = "1", in = ParameterIn.PATH ) Integer apartmentId) {
        return apartmentService.getApartmentById(apartmentId);
    }

    @PostMapping
    @Operation(summary = "Create a new apartment", description = "Create a new apartment", tags = { "apartment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apartment created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Apartment already exists")
    })
    public Apartment addApartment(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @RequestBody Apartment apartment) {
        return apartmentService.createApartment(apartment);
    }

    @PutMapping("/{apartmentId}")
    @Operation(summary = "Update a apartment", description = "Update a apartment", tags = { "apartment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apartment updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Apartment not found")
    })
    public Apartment updateApartment(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @PathVariable @Parameter(name = "apartmentId", required = true, example = "1", in = ParameterIn.PATH ) Integer apartmentId, @RequestBody Apartment apartment) {
        return apartmentService.updateApartment(apartmentId, apartment);
    }

    @GetMapping("/pincode/{pinCode}")
    @Operation(summary = "Get a apartment by pincode", description = "Get a apartment by pincode", tags = { "apartment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apartment fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Apartment not found")
    })
    public List<Apartment> getApartmentByPinCode(@PathVariable @Parameter(name = "pinCode", required = true, example = "201304", in = ParameterIn.PATH ) String pinCode) {
        return apartmentService.getApartmentByPinCode(pinCode);
    }

    @GetMapping("/name/{apartmentName}")
    @Operation(summary = "Get a apartment by name", description = "Get a apartment by name", tags = { "apartment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apartment fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Apartment not found")
    })
    public List<Apartment> getBuildingByName(@PathVariable String apartmentName) {
        return apartmentService.getApartmentByName(apartmentName);
    }

    @DeleteMapping("/{apartmentId}")
    @Operation(summary = "Delete a apartment", description = "Delete a apartment", tags = { "apartment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apartment deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Apartment not found")
    })
    public Apartment deleteApartment(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @PathVariable @Parameter(name = "apartmentId", required = true, example = "1", in = ParameterIn.PATH ) Integer apartmentId) {
        return apartmentService.deleteApartment(apartmentId);
    }

    @PostMapping("/search")
    @Operation(summary = "Search a apartment", description = "Search a apartment", tags = { "apartment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apartment searched successfully"),
            @ApiResponse(responseCode = "404", description = "Apartment not found")
    })
    public List<Apartment> searchApartment(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @RequestBody SearchRequest searchRequest) {
        return apartmentService.searchApartment(searchRequest);
    }
}
