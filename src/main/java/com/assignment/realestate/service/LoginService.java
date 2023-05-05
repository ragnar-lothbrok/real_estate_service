package com.assignment.realestate.service;

public interface LoginService {

    String login(String username, String password);

    Integer getUserIdFromToken(String token);
}
