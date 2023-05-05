package com.assignment.realestate.service.impl;

import com.assignment.realestate.entity.user.RealEstateUser;
import com.assignment.realestate.repo.UserRepository;
import com.assignment.realestate.service.UserService;
import com.assignment.realestate.threadlocal.ContextHolder;
import com.assignment.realestate.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RealEstateUser addUser(RealEstateUser user) {
        return MapperUtil.fromRealEstateUser(userRepository.save(user));
    }

    @Override
    public RealEstateUser updateUser(Integer userId, RealEstateUser user) {
        if(ContextHolder.getUserId().intValue() == userId) {
            return MapperUtil.fromRealEstateUser(userRepository.save(user));
        }
        return user;
    }

    @Override
    public RealEstateUser getUserById(int userId) {
        RealEstateUser realEstateUser = null;
        if(ContextHolder.getUserId().intValue() == userId) {
            realEstateUser = userRepository.findById(ContextHolder.getUserId()).get();
        }
        return MapperUtil.fromRealEstateUser(realEstateUser);
    }

    @Override
    public RealEstateUser getUserByEmail(String email) {
        return MapperUtil.fromRealEstateUser(userRepository.findByEmailId(email));
    }

    @Override
    public RealEstateUser getUserByPhoneNumber(String phoneNumber) {
        return MapperUtil.fromRealEstateUser(userRepository.findByPhoneNumber(phoneNumber));
    }

    @Override
    public List<RealEstateUser> findAllUsers() {
        return MapperUtil.fromRealEstateUsers(userRepository.findAll());
    }
}
