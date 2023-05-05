package com.assignment.realestate.repo;

import com.assignment.realestate.entity.location.Country;
import com.assignment.realestate.entity.location.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
    List<State> findAllByCountry(Country country);

}
