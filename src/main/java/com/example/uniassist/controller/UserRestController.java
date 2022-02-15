package com.example.uniassist.controller;

import com.example.uniassist.dto.UserDTO;
import com.example.uniassist.model.User;
import com.example.uniassist.service.UserService;
import com.example.uniassist.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public List<UserDTO> getAllUsers() {
        return ObjectMapperUtils.mapAll(userService.findAll(), UserDTO.class);
    }

    @GetMapping(value = "/byUserNumber/{UserNumber}")
    public UserDTO getUserByUserNumber(@PathVariable("UserNumber") Long UserNumber) {
        return ObjectMapperUtils.map(userService.findByUserNumber(UserNumber), UserDTO.class);
    }

    @GetMapping(value = "/byEmail/{email}")
    public UserDTO getUserByEmail(@PathVariable("email") String email) {
        return ObjectMapperUtils.map(userService.findByEmail(email), UserDTO.class);
    }



    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateUser(@RequestBody UserDTO UserDTO) {
        userService.saveOrUpdateUser(ObjectMapperUtils.map(UserDTO, User.class));
        return new ResponseEntity("User added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{UserNumber}")
    public ResponseEntity<?> deleteUserByUserNumber(@PathVariable long UserNumber) {
        userService.deleteUserById(userService.findByUserNumber(UserNumber).getUserName());
        return new ResponseEntity("User deleted successfully", HttpStatus.OK);
    }

}
