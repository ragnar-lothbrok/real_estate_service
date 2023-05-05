package com.assignment.realestate.controller;

import com.assignment.realestate.dto.*;
import com.assignment.realestate.entity.estates.UserBuysApartment;
import com.assignment.realestate.entity.estates.UserOwnsApartment;
import com.assignment.realestate.entity.estates.UserRentsApartment;
import com.assignment.realestate.entity.estates.UserVisitApartment;
import com.assignment.realestate.service.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RequestMapping("/api/v1/activity")
@RestController
public class UserActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/buy")
    @Operation(summary = "User buys apartment")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "User buys apartment"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "Apartment already bought"),
    })
    public UserBuysApartment userBuysApartment(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @RequestBody UserBuysDto userBuysDto) {
        return activityService.userBuysApartment(userBuysDto);
    }

    @PostMapping("/rent")
    @Operation(summary = "User rents apartment")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "User rents apartment"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "Apartment already rented"),
    })
    public UserRentsApartment userRentsApartment(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @RequestBody UserRentsDto userRentsDto) {
        return activityService.userRentsApartment(userRentsDto);
    }

    @PostMapping("/own")
    @Operation(summary = "User owns apartment")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "User owns apartment"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "Apartment already owned"),
    })
    public UserOwnsApartment userOwnsApartment(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @RequestBody UserOwnsDto userOwnsDto) {
        return activityService.userOwnsApartment(userOwnsDto);
    }

    @PostMapping("/visit")
    @Operation(summary = "User visits apartment")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "User visits apartment"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "Apartment already visited"),
    })
    public UserVisitApartment userVisitsApartment(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @RequestBody UserVisitsDto userVisitsDto) {
        return activityService.userVisitsApartment(userVisitsDto);
    }

    @PostMapping("/manage")
    @Operation(summary = "Manage user")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Manage user"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "User already managed"),
    })
    public UserActivityDto manageUser(@RequestHeader(name = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @RequestBody UserActivityDto userActivityDto) {
        return activityService.manageUser(userActivityDto);
    }
}
