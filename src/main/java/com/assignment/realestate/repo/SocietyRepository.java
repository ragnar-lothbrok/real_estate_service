package com.assignment.realestate.repo;

import com.assignment.realestate.entity.estates.Society;
import com.assignment.realestate.entity.location.PinCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocietyRepository extends JpaRepository<Society, Integer> {

    List<Society> findByPinCode(PinCode byId);

    List<Society> findBySocietyNameContaining(String name);
}
