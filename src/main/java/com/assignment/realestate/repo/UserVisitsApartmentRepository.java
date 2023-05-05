package com.assignment.realestate.repo;

import com.assignment.realestate.entity.estates.UserVisitApartment;
import com.assignment.realestate.entity.estates.UserVisitApartmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVisitsApartmentRepository extends JpaRepository<UserVisitApartment, UserVisitApartmentId> {
    
}
