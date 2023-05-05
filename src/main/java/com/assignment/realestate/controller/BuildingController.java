package com.assignment.realestate.controller;

import com.assignment.realestate.dto.SearchRequest;
import com.assignment.realestate.entity.estates.Apartment;
import com.assignment.realestate.entity.estates.Building;
import com.assignment.realestate.service.BuildingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("/api/v1/building")
@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping
    @Operation(summary = "Get all buildings", description = "Get all buildings", tags = { "building" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Buildings fetched successfully")
    })
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping("/{buildingId}")
    @Operation(summary = "Get a building by id", description = "Get a building by id", tags = { "building" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Building fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Building not found")
    })
    public Building getBuildingById(@PathVariable Integer buildingId) {
        return buildingService.getBuildingById(buildingId);
    }

    @PostMapping
    @Operation(summary = "Create a new building", description = "Create a new building", tags = { "building" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Building created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Building already exists")
    })
    public Building addBuilding(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @RequestBody Building building) {
        return buildingService.createBuilding(building);
    }

    @PutMapping("/{buildingId}")
    @Operation(summary = "Update a building", description = "Update a building", tags = { "building" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Building updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Building not found")
    })
    public Building updateBuilding(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @PathVariable Integer buildingId, @RequestBody Building building) {
        return buildingService.updateBuilding(buildingId, building);
    }

    @GetMapping("/pincode/{pincode}")
    @Operation(summary = "Get all buildings by pincode", description = "Get all buildings by pincode", tags = { "building" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Buildings fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Building not found")
    })
    public List<Building> getBuildingByPinCode(@PathVariable String pincode) {
        return buildingService.getBuildingByPinCode(pincode);
    }

    @GetMapping("/name/{buildingName}")
    @Operation(summary = "Get all buildings by name", description = "Get all buildings by name", tags = { "building" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Buildings fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Building not found")
    })
    public List<Building> getBuildingByName(@PathVariable String buildingName) {
        return buildingService.getBuildingByName(buildingName);
    }

    @GetMapping("/{buildingId}/apartments")
    @Operation(summary = "Get all apartments by building", description = "Get all apartments by building", tags = { "building" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apartments fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Building not found")
    })
    public List<Apartment> getApartmentsByBuildingId(@PathVariable Integer buildingId) {
        return buildingService.getBuildingById(buildingId).getApartments();
    }

    @DeleteMapping("/{buildingId}")
    @Operation(summary = "Delete a building", description = "Delete a building", tags = { "building" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Building deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Building not found")
    })
    public ResponseEntity deleteBuilding(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @PathVariable Integer buildingId) {
        buildingService.deleteBuilding(buildingId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    @Operation(summary = "Search buildings", description = "Search buildings", tags = { "building" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Buildings fetched successfully")
    })
    public List<Building> searchBuilding(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @RequestBody SearchRequest searchRequest) {
        return buildingService.searchBuilding(searchRequest);
    }
}
