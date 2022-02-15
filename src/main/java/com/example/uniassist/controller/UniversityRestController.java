package com.example.uniassist.controller;


import com.example.uniassist.dto.UniversityDTO;
import com.example.uniassist.model.University;
import com.example.uniassist.repository.UniversityRepository;
import com.example.uniassist.service.UniversityService;
import com.example.uniassist.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityRestController {

    private UniversityRepository universityRepository;

    @Autowired
    private UniversityService universityService;


    @GetMapping(value = "/byCountry/{country}")
    public List<University> getUniversityByCountry(@PathVariable("country")String country) {
        return universityService.findUniversityByCountryIs(country);
    }

    @GetMapping(value = "/byFaculty/{faculty}")
    public List<University> getUniByFaculty(@PathVariable("faculty")String faculty) {
        //List<University> list = universityService.findUniversityByFacultiesContaining(faculty);
        return universityService.findUniversityByFacultiesContaining(faculty);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateUniversity(@RequestBody UniversityDTO UniversityDTO) {
        universityService.saveOrUpdateUniversity(ObjectMapperUtils.map(UniversityDTO, University.class));
        return new ResponseEntity("University added successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/byCountryCont/{country}")
    public UniversityDTO getCoutryContains(@PathVariable("country")String country) {
        return ObjectMapperUtils.map(universityService.findByCountryContaining(country), UniversityDTO.class);
    }




}
