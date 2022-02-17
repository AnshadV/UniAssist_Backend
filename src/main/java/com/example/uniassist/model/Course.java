package com.example.uniassist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Course {
    
    private Long courseId;
    private String courseName;
    private Long uniID;
    private String faculty;
    private String appOpen;
    private String deadline;
    private String cost;
    private String duration;

    public Course() {

    }

    public Course(Long courseId, String courseName, Long uniID, String faculty,
                  String appOpen, String deadline, String cost, String duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.uniID = uniID;
        this.faculty = faculty;
        this.appOpen = appOpen;
        this.deadline = deadline;
        this.cost = cost;
        this.duration = duration;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Long getUniID() {
        return uniID;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getCost() {
        return cost;
    }

    public String getAppOpen() {
        return appOpen;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getDuration() {
        return duration;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setAppOpen(String appOpen) {
        this.appOpen = appOpen;
    }

    public void setUniID(Long uniID) {
        this.uniID = uniID;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }



}
