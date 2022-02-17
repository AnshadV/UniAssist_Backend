package com.example.uniassist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection ="universities")
public class University {
    @Id
    private Long uniID;
    private String uniName;
    private String country;
    private List<String> faculties;
    private Course course;

    public University() {

    }

    public University(Long uniID, String uniName, String country,
                      List<String> faculties, Course course){
        this.uniID = uniID;
        this.uniName = uniName;
        this.country = country;
        this.faculties = faculties;
        this.course = course;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
