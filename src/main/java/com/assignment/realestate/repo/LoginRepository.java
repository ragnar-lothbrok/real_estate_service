package com.assignment.realestate.repo;

import com.assignment.realestate.entity.user.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserCredential, Integer> {

}
