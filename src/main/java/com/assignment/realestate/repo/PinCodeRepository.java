package com.assignment.realestate.repo;

import com.assignment.realestate.entity.location.Country;
import com.assignment.realestate.entity.location.PinCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PinCodeRepository extends JpaRepository<PinCode, String> {

    Optional<PinCode> findByCountryAndPin(Country country, String pin);

}
