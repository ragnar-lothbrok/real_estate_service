package com.assignment.realestate.repo;

import com.assignment.realestate.entity.estates.Apartment;
import com.assignment.realestate.entity.estates.Building;
import com.assignment.realestate.entity.location.PinCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {

    List<Apartment> findByApartmentNameContaining(String name);

    List<Apartment> findByBuilding(Building building);

    List<Apartment> findByPinCode(PinCode one);
}
