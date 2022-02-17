package com.example.uniassist.repository;

import com.example.uniassist.model.Course;
import com.example.uniassist.model.University;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UniversityRepository extends MongoRepository<University, Long> {

    University findUniversityByUniID(long uniID);
    List<University> findUniversityByCountryIs(String country);
    List<University> findUniversityByFacultiesIs(String faculties);
    List<University> findByCountryContaining(String country);
    List<University> findUniversityByFacultiesContaining(String faculty);

    List<University> findUniversityByCourse_UniID(long uniID);
}
