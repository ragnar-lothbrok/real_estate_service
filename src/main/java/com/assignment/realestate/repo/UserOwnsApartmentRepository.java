package com.assignment.realestate.repo;

import com.assignment.realestate.entity.estates.UserApartmentId;
import com.assignment.realestate.entity.estates.UserOwnsApartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOwnsApartmentRepository extends JpaRepository<UserOwnsApartment, UserApartmentId> {
    
}
