package com.example.uniassist.service;

import com.example.uniassist.model.University;

import java.util.List;

public interface UniversityService {

    List<University> findAll();

    University findUniversityByUniID(long uniID);

    List<University> findUniversityByCountryIs(String country);

    List<University> findUniversityByFacultiesIs(String faculties);

    University saveOrUpdateUniversity(University University);

    List<University> findByCountryContaining(String country);


    List<University> findUniversityByFacultiesContaining(String faculty);
}
