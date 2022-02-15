package com.example.uniassist.service;

import com.example.uniassist.model.User;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findByUserNumber(long UserNumber);

    User findByEmail(String email);

    User saveOrUpdateUser(User User);

    void deleteUserById(String userName);


}
