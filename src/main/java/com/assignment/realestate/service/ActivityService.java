package com.assignment.realestate.service;

import com.assignment.realestate.dto.*;
import com.assignment.realestate.entity.estates.*;

import java.util.List;

public interface ActivityService {
    UserBuysApartment userBuysApartment(UserBuysDto userBuysDto);

    UserVisitApartment userVisitsApartment(UserVisitsDto userVisitsDto);

    UserOwnsApartment userOwnsApartment(UserOwnsDto userOwnsDto);

    UserRentsApartment userRentsApartment(UserRentsDto userRentsDto);

    UserActivityDto manageUser(UserActivityDto userActivityDto);
}
