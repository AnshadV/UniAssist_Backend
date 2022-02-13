package com.example.uniassist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "users")
public class User {
    @Id
    private String userName;
    private String fToken;
    private String name;
    private long UserNumber;
    private String email;
    private String degree;
    private String term;
    private String year;
    private List<String> courseList;
    private List<String> countryList;

    public User() {
    }

    public User(String userName, String fToken, String name, long UserNumber, String email,String degree, String term, String year, List<String> courseList, List<String> countryList) {
        this.userName = userName;
        this.fToken = fToken;
        this.name = name;
        this.UserNumber = UserNumber;
        this.email = email;
        this.degree = degree;
        this.term = term;
        this.year = year;
        this.courseList = courseList;
        this.countryList = countryList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String id) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserNumber() {
        return UserNumber;
    }

    public void setUserNumber(long UserNumber) {
        this.UserNumber = UserNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfToken() {
        return fToken;
    }

    public void setfToken(String fToken) {
        this.fToken = fToken;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public void setCountryList(List<String> countryList) {
        this.countryList = countryList;
    }

    public List<String> getCountryList() {
        return countryList;
    }

    public List<String> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<String> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", UserNumber=" + UserNumber +
                ", email='" + email + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
