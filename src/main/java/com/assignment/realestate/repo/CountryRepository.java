package com.assignment.realestate.repo;

import com.assignment.realestate.entity.location.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    List<Country> findByNameContaining(String countryName);
}
