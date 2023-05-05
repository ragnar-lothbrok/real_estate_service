package com.assignment.realestate.repo;

import com.assignment.realestate.entity.estates.Building;
import com.assignment.realestate.entity.estates.Society;
import com.assignment.realestate.entity.location.PinCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
    List<Building> findByPinCode(PinCode pinCode);

    List<Building> findBySociety(Society society);

    List<Building> findByBuildingNameContaining(String name);
}
