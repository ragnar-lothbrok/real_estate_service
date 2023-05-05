package com.assignment.realestate.controller;

import com.assignment.realestate.dto.UserLoginDto;
import com.assignment.realestate.service.LoginService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/login")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User logged in"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "401", description = "User not found"),
    })
    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto) {
        return ResponseEntity.ok(loginService.login(userLoginDto.getUserName(), userLoginDto.getPassword()));
    }
}
