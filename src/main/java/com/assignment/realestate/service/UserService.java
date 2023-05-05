package com.assignment.realestate.service;

import com.assignment.realestate.entity.user.RealEstateUser;

import java.util.List;

public interface UserService {

    RealEstateUser addUser(RealEstateUser user);

    RealEstateUser updateUser(Integer userId, RealEstateUser user);

    RealEstateUser getUserById(int userId);

    RealEstateUser getUserByEmail(String email);

    RealEstateUser getUserByPhoneNumber(String phoneNumber);

    List<RealEstateUser> findAllUsers();
}
