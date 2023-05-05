package com.assignment.realestate.service.impl;

import com.assignment.realestate.dto.*;
import com.assignment.realestate.entity.estates.*;
import com.assignment.realestate.repo.UserBuysApartmentRepository;
import com.assignment.realestate.repo.UserOwnsApartmentRepository;
import com.assignment.realestate.repo.UserRentsApartmentRepository;
import com.assignment.realestate.repo.UserVisitsApartmentRepository;
import com.assignment.realestate.service.ActivityService;
import com.assignment.realestate.service.ApartmentService;
import com.assignment.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.ZoneId;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserBuysApartmentRepository userBuysApartmentRepository;

    @Autowired
    private UserVisitsApartmentRepository userVisitsApartmentRepository;

    @Autowired
    private UserOwnsApartmentRepository userOwnsApartmentRepository;

    @Autowired
    private UserRentsApartmentRepository userRentsApartmentRepository;

    @Autowired
    private DataSource dataSource;

    @Override
    public UserBuysApartment userBuysApartment(UserBuysDto userBuysDto) {
        return userBuysApartmentRepository.save(new UserBuysApartment()
                .setUserBuysApartmentId(new UserBuysApartmentId()
                        .setBoughtDate(userBuysDto.getBoughtDate())
                        .setApartment(apartmentService.getApartmentById(userBuysDto.getApartmentId()))
                        .setRealEstateUser(userService.getUserById(userBuysDto.getUserId()))));
    }

    @Override
    public UserVisitApartment userVisitsApartment(UserVisitsDto userVisitsDto) {
        return userVisitsApartmentRepository.save(new UserVisitApartment()
                .setInterested(true)
                .setUserVisitApartmentId(new UserVisitApartmentId()
                        .setVisitedDate(userVisitsDto.getVisitDate())
                        .setApartment(apartmentService.getApartmentById(userVisitsDto.getApartmentId()))
                        .setRealEstateUser(userService.getUserById(userVisitsDto.getUserId()))));
    }

    @Override
    public UserOwnsApartment userOwnsApartment(UserOwnsDto userOwnsDto) {
        return userOwnsApartmentRepository.save(new UserOwnsApartment()
                .setUserApartmentId(new UserApartmentId()
                        .setApartment(apartmentService.getApartmentById(userOwnsDto.getApartmentId()))
                        .setRealEstateUser(userService.getUserById(userOwnsDto.getUserId()))));
    }

    @Override
    public UserRentsApartment userRentsApartment(UserRentsDto userRentsDto) {
        return userRentsApartmentRepository.save(new UserRentsApartment()
                .setRentPerMonth(userRentsDto.getRentPerMonth())
                .setSecurityDeposit(userRentsDto.getSecurityDeposit()).setUserRentsApartmentId(new UserRentsApartmentId()
                        .setStartDate(userRentsDto.getStartDate())
                        .setApartment(apartmentService.getApartmentById(userRentsDto.getApartmentId()))
                        .setRealEstateUser(userService.getUserById(userRentsDto.getUserId()))));
    }

    @Override
    public UserActivityDto manageUser(UserActivityDto userActivityDto) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            if ("Apartment_Visit".equalsIgnoreCase(userActivityDto.getUserAction())) {

                connection = dataSource.getConnection();
                pstmt = connection.prepareStatement("call add_apartment_visits(?,?, ?)");
                pstmt.setArray(1, connection.createArrayOf("integer", userActivityDto.getUserIds().toArray(new Integer[userActivityDto.getUserIds().size()])));
                pstmt.setArray(2, connection.createArrayOf("integer", userActivityDto.getApartmentIds().toArray(new Integer[userActivityDto.getApartmentIds().size()])));
                pstmt.setDate(3, Date.valueOf(userActivityDto.getDate()));
                pstmt.executeUpdate();

            } else if ("Apartment_Ownership".equalsIgnoreCase(userActivityDto.getUserAction())) {
                for (Integer apartmentId : userActivityDto.getApartmentIds()) {

                    connection = dataSource.getConnection();
                    pstmt = connection.prepareStatement("call update_apartment_owners(?,?)");
                    pstmt.setArray(1, connection.createArrayOf("integer", userActivityDto.getUserIds().toArray(new Integer[userActivityDto.getUserIds().size()])));
                    pstmt.setInt(2, apartmentId);
                    pstmt.executeUpdate();

                }
            } else if ("Apartment_Rent".equalsIgnoreCase(userActivityDto.getUserAction())) {

                connection = dataSource.getConnection();
                pstmt = connection.prepareStatement("call add_apartment_rent_details(?,?, ?, ?, ?)");
                pstmt.setArray(1, connection.createArrayOf("integer", userActivityDto.getUserIds().toArray(new Integer[userActivityDto.getUserIds().size()])));
                pstmt.setArray(2, connection.createArrayOf("integer", userActivityDto.getApartmentIds().toArray(new Integer[userActivityDto.getApartmentIds().size()])));
                pstmt.setDate(3, Date.valueOf(userActivityDto.getDate()));
                pstmt.setInt(4, userActivityDto.getRentPerMonth());
                pstmt.setInt(5, userActivityDto.getSecurityDeposit());
                pstmt.executeUpdate();

            } else if ("Apartment_Purchase".equalsIgnoreCase(userActivityDto.getUserAction())) {

                connection = dataSource.getConnection();
                pstmt = connection.prepareStatement("call add_apartment_purchase_details(?,?, ?)");
                pstmt.setArray(1, connection.createArrayOf("integer", userActivityDto.getUserIds().toArray(new Integer[userActivityDto.getUserIds().size()])));
                pstmt.setArray(2, connection.createArrayOf("integer", userActivityDto.getApartmentIds().toArray(new Integer[userActivityDto.getApartmentIds().size()])));
                pstmt.setDate(3, Date.valueOf(userActivityDto.getDate()));
                pstmt.executeUpdate();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userActivityDto;
    }
}
