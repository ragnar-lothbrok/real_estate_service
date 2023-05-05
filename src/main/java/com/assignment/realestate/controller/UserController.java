package com.assignment.realestate.controller;

import com.assignment.realestate.entity.user.RealEstateUser;
import com.assignment.realestate.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RequestMapping("/api/v1/user")
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Operation(summary = "Create a new user", description = "Create a new user", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "User already exists")
    })
    public RealEstateUser createUser(@RequestHeader(name = "Authorization") @NotBlank String authorization,@Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @RequestBody RealEstateUser realEstateUser) {
        return userService.addUser(realEstateUser);
    }

    @PutMapping("/{userId}")
    @Operation(summary = "Update a user", description = "Update a user", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public Object updateUserById(@RequestHeader(name = "Authorization") @NotBlank String authorization,@Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @PathVariable @Parameter(name = "userId", required = true, example = "1", in = ParameterIn.PATH ) Integer id, @RequestBody RealEstateUser realEstateUser) {
        return userService.updateUser(id, realEstateUser);
    }

    @GetMapping
    @Operation(summary = "Get all users", description = "Get all users", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users fetched successfully")
    })
    public Object getAllUsers(@ModelAttribute("USER_ID") @Nullable Integer loggedInUserId) {
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Get a user by id", description = "Get a user by id", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User fetched successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public Object getUserById(@RequestHeader(name = "Authorization") @NotBlank String authorization,@Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @PathVariable @Parameter(name = "userId", required = true, example = "1", in = ParameterIn.PATH ) Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get a user by email", description = "Get a user by email", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User fetched successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public Object getUserByEmail(@RequestHeader(value = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @PathVariable @Parameter(name = "email", required = true, example = "xyz@gmail.com", in = ParameterIn.PATH ) String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/phone/{phoneNumber}")
    @Operation(summary = "Get a user by phone number", description = "Get a user by phone number", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User fetched successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public Object getUserByPhoneNumber(@RequestHeader(value = "Authorization") @NotBlank String authorization, @Parameter(hidden = true) @ModelAttribute("USER_ID") @NotBlank Integer loggedInUserId, @PathVariable @Parameter(name = "phoneNumber", required = true, example = "9182760211", in = ParameterIn.PATH ) String phoneNumber) {
        return userService.getUserByPhoneNumber(phoneNumber);
    }
}
