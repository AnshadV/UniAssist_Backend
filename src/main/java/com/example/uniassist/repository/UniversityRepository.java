package com.example.uniassist.repository;

import com.example.uniassist.model.University;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UniversityRepository extends MongoRepository<University, Long> {

    University findUniversityByUniID(long uniID);
    List<University> findUniversityByCountryIs(String country);
    List<University> findUniversityByFacultiesIs(String faculties);
    List<University> findByCountryContaining(String country);
    List<University> findUniversityByFacultiesContaining(String faculty);
}
