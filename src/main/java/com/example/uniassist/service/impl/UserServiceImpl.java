package com.example.uniassist.service.impl;


import com.example.uniassist.model.User;
import com.example.uniassist.repository.UserRepository;
import com.example.uniassist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository UserRepository;

    @Override
    public List<User> findAll() {
        return UserRepository.findAll();
    }

    @Override
    public User findByUserNumber(long UserNumber) {
        return UserRepository.findByUserNumber(UserNumber);
    }

    @Override
    public User findByEmail(String email) {
        return UserRepository.findByEmail(email);
    }


    @Override
    public User saveOrUpdateUser(User User) {
        return UserRepository.save(User);
    }

    @Override
    public void deleteUserById(String userName) {
        UserRepository.deleteById(userName);
    }
}
