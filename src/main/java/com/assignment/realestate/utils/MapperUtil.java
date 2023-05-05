package com.assignment.realestate.utils;

import com.assignment.realestate.dto.UserBuysDto;
import com.assignment.realestate.dto.UserOwnsDto;
import com.assignment.realestate.dto.UserRentsDto;
import com.assignment.realestate.dto.UserVisitsDto;
import com.assignment.realestate.entity.estates.*;
import com.assignment.realestate.entity.user.RealEstateUser;

import java.util.*;
import java.util.stream.Collectors;

public class MapperUtil {

    private static Set<UserOwnsDto> fromUserOwnsApartment(Set<UserOwnsApartment> userOwnsApartments) {
        if(userOwnsApartments == null || userOwnsApartments.isEmpty()) {
            return null;
        }
        return userOwnsApartments.stream().map(
                userOwnsApartment -> new UserOwnsDto().setApartmentId(userOwnsApartment.getUserApartmentId().getApartment().getApartmentId()).setUserId(userOwnsApartment.getUserApartmentId().getRealEstateUser().getUserId())
        ).collect(Collectors.toSet());
    }

    private static Set<UserRentsDto> fromUserRentsApartment(Set<UserRentsApartment> userRentsApartments) {
        return Optional.ofNullable(userRentsApartments)
                .map(apartments -> apartments.stream().map(
                        userRentsApartment -> new UserRentsDto()
                                .setUserId(userRentsApartment.getUserRentsApartmentId().getRealEstateUser().getUserId())
                                .setApartmentId(userRentsApartment.getUserRentsApartmentId().getApartment().getApartmentId())
                                .setRentPerMonth(userRentsApartment.getRentPerMonth())
                                .setSecurityDeposit(userRentsApartment.getSecurityDeposit())
                                .setStartDate(userRentsApartment.getUserRentsApartmentId().getStartDate())
                ).collect(Collectors.toSet()))
                .orElse(Collections.emptySet());
    }

    private static Set<UserBuysDto> fromUserBuysApartment(Set<UserBuysApartment> userBuysApartments) {
        return Optional.ofNullable(userBuysApartments)
                .map(apartments -> apartments.stream().map(
                        userBuysApartment -> new UserBuysDto()
                                .setUserId(userBuysApartment.getUserBuysApartmentId().getRealEstateUser().getUserId())
                                .setApartmentId(userBuysApartment.getUserBuysApartmentId().getApartment().getApartmentId())
                                .setBoughtDate(userBuysApartment.getUserBuysApartmentId().getBoughtDate())
                ).collect(Collectors.toSet()))
                .orElse(Collections.emptySet());
    }

    private static Set<UserVisitsDto> fromUserVisitsApartment(Set<UserVisitApartment> userVisitsApartments) {
        return Optional.ofNullable(userVisitsApartments)
                .map(apartments -> apartments.stream().map(
                        userVisitsApartment -> new UserVisitsDto()
                                .setUserId(userVisitsApartment.getUserVisitApartmentId().getRealEstateUser().getUserId())
                                .setApartmentId(userVisitsApartment.getUserVisitApartmentId().getApartment().getApartmentId())
                                .setVisitDate(userVisitsApartment.getUserVisitApartmentId().getVisitedDate())
                ).collect(Collectors.toSet()))
                .orElse(Collections.emptySet());
    }

    public static RealEstateUser fromRealEstateUser(RealEstateUser user) {
        if(Objects.nonNull(user)) {
            user
                    .setUserBuysDtos(fromUserBuysApartment(user.getUserBuysApartments()))
                    .setUserRentDtos(fromUserRentsApartment(user.getUserRentsApartments()))
                    .setUserOwnsDtos(fromUserOwnsApartment(user.getUserOwnsApartments()))
                    .setUserVisitsDtos(fromUserVisitsApartment(user.getUserVisitApartments()));
        }
        return user;
    }

    public static List<RealEstateUser> fromRealEstateUsers(List<RealEstateUser> users) {
        if(Objects.nonNull(users)) {
            users.forEach(user -> {
                user
                        .setUserBuysDtos(fromUserBuysApartment(user.getUserBuysApartments()))
                        .setUserRentDtos(fromUserRentsApartment(user.getUserRentsApartments()))
                        .setUserOwnsDtos(fromUserOwnsApartment(user.getUserOwnsApartments()))
                        .setUserVisitsDtos(fromUserVisitsApartment(user.getUserVisitApartments()));
            });
        }
        return users;
    }

    public static Apartment fromApartment(Apartment apartment) {
        if(Objects.nonNull(apartment)) {
            apartment
                    .setUserBuysDtos(fromUserBuysApartment(apartment.getUserBuysApartments()))
                    .setUserRentDtos(fromUserRentsApartment(apartment.getUserRentsApartments()))
                    .setUserOwnsDtos(fromUserOwnsApartment(apartment.getUserOwnsApartments()))
                    .setUserVisitsDtos(fromUserVisitsApartment(apartment.getUserVisitApartments()));
        }
        return apartment;
    }

    public static List<Apartment> fromApartments(List<Apartment> apartments) {
        if(Objects.nonNull(apartments)) {
            apartments.forEach(apartment -> {
                apartment
                        .setUserBuysDtos(fromUserBuysApartment(apartment.getUserBuysApartments()))
                        .setUserRentDtos(fromUserRentsApartment(apartment.getUserRentsApartments()))
                        .setUserOwnsDtos(fromUserOwnsApartment(apartment.getUserOwnsApartments()))
                        .setUserVisitsDtos(fromUserVisitsApartment(apartment.getUserVisitApartments()));
            });
        }
        return apartments;
    }

}
