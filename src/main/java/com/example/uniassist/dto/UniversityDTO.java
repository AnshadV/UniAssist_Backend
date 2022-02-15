package com.example.uniassist.dto;

import java.util.List;

public class UniversityDTO {
    private Long uniID;
    private String uniName;
    private String country;
    private List<String> faculties;

    public UniversityDTO() {

    }

    public UniversityDTO(Long uniID, String uniName, String country, List<String> faculties){
        this.uniID = uniID;
        this.uniName = uniName;
        this.country = country;
        this.faculties = faculties;
    }

    public void setUniId(Long uniID) {
        this.uniID = uniID;
    }

    public Long getUniID() {
        return uniID;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getUniName() {
        return uniName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<String> faculties) {
        this.faculties = faculties;
    }
}
