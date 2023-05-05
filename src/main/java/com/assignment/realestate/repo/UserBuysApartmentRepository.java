package com.assignment.realestate.repo;

import com.assignment.realestate.entity.estates.UserBuysApartment;
import com.assignment.realestate.entity.estates.UserBuysApartmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBuysApartmentRepository extends JpaRepository<UserBuysApartment, UserBuysApartmentId> {

}
