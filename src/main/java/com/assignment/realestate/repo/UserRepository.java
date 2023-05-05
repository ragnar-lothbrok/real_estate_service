package com.assignment.realestate.repo;

import com.assignment.realestate.entity.user.RealEstateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<RealEstateUser, Integer> {

    RealEstateUser findByEmailId(String email);

    RealEstateUser findByPhoneNumber(String phoneNumber);
}
