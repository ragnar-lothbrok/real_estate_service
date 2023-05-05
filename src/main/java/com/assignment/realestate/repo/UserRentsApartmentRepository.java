package com.assignment.realestate.repo;

import com.assignment.realestate.entity.estates.UserRentsApartment;
import com.assignment.realestate.entity.estates.UserRentsApartmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRentsApartmentRepository extends JpaRepository<UserRentsApartment, UserRentsApartmentId> {
    
}
