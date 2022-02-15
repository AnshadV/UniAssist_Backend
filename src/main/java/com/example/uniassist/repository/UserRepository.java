package com.example.uniassist.repository;

import com.example.uniassist.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;



// No need implementation, just one interface, and you have CRUD, thanks Spring Data!
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserNumber(long UserNumber);

    User findByEmail(String email);


}
