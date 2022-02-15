package com.example.uniassist.service.impl;

import com.example.uniassist.model.University;
import com.example.uniassist.repository.UniversityRepository;
import com.example.uniassist.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public List<University> findAll() {
        return universityRepository.findAll();
    }

    @Override
    public University findUniversityByUniID(long uniID) {
        return universityRepository.findUniversityByUniID(uniID);
    }

    @Override
    public List<University> findUniversityByCountryIs(String country) {
        return universityRepository.findUniversityByCountryIs(country);
    }

    @Override
    public List<University> findUniversityByFacultiesIs(String faculties) {
        return universityRepository.findUniversityByFacultiesIs(faculties);
    }

    @Override
    public University saveOrUpdateUniversity(University University) {
        return universityRepository.save(University);
    }

    @Override
    public List<University> findByCountryContaining(String country) {
        return universityRepository.findByCountryContaining(country);
    }

    @Override
    public List<University> findUniversityByFacultiesContaining(String faculty) {
        return universityRepository.findUniversityByFacultiesContaining(faculty);
    }


}
