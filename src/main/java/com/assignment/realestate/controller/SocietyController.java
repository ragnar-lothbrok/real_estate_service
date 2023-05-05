package com.assignment.realestate.controller;

import com.assignment.realestate.dto.SearchRequest;
import com.assignment.realestate.entity.estates.Building;
import com.assignment.realestate.entity.estates.Society;
import com.assignment.realestate.service.SocietyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@RequestMapping("/api/v1/society")
@RestController
public class SocietyController {

    @Autowired
    private SocietyService societyService;

    @GetMapping
    @Operation(summary = "Get all societies", description = "Get all societies", tags = { "society" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Societies fetched successfully")
    })
    public List<Society> getAllSocieties() {
        return societyService.getAllSociety();
    }

    @PostMapping
    @Operation(summary = "Create a new society", description = "Create a new society", tags = { "society" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Society created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Society already exists")
    })
    public Society createSociety(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @RequestBody Society society) {
        return societyService.createSociety(society);
    }

    @PutMapping("/{societyId}")
    @Operation(summary = "Update a society", description = "Update a society", tags = { "society" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Society updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Society not found")
    })
    public Society updateSociety(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @PathVariable Integer societyId, @RequestBody Society society) {
        return societyService.updateSociety(societyId, society);
    }


    @GetMapping("/pincode/{pincode}")
    @Operation(summary = "Get all societies by pincode", description = "Get all societies by pincode", tags = { "society" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Societies fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Society not found")
    })
    public List<Society> getBuildingByPinCode(@PathVariable String pincode) {
        return societyService.getSocietyByPincode(pincode);
    }

    @GetMapping("/name/{societyName}")
    @Operation(summary = "Get all societies by name", description = "Get all societies by name", tags = { "society" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Societies fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Society not found")
    })
    public List<Society> getSocietyByName(@PathVariable String societyName) {
        return societyService.getSocietyByName(societyName);
    }

    @GetMapping("/{societyId}/buildings")
    @Operation(summary = "Get all buildings by society id", description = "Get all buildings by society id", tags = { "society" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Buildings fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Society not found")
    })
    public Set<Building> getBuildingsBySocietyId(@PathVariable Integer societyId) {
        return societyService.getSocietyById(societyId).getBuildings();
    }

    @DeleteMapping("/{societyId}")
    @Operation(summary = "Delete a society", description = "Delete a society", tags = { "society" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Society deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Society not found")
    })
    public ResponseEntity deleteSociety(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @PathVariable Integer societyId) {
        societyService.deleteSociety(societyId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    @Operation(summary = "Search societies", description = "Search societies", tags = { "society" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Societies fetched successfully")
    })
    public List<Society> searchSociety(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @RequestBody SearchRequest searchRequest) {
        return societyService.searchSociety(searchRequest);
    }
}
