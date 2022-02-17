package com.example.uniassist.controller;


import com.example.uniassist.model.Course;
import com.example.uniassist.repository.CourseRepository;
import com.example.uniassist.repository.UniversityRepository;
import com.example.uniassist.service.CourseSrevice;
import com.example.uniassist.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseRestController {

    private CourseRepository CourseRepository;

    @Autowired
    private CourseSrevice courseSrevice;

    @GetMapping("byCourse/{courseId}")
    public Course getCourseByCourseId(@PathVariable("courseId") long courseId) {
        return courseSrevice.findCourseByCourseId(courseId);
    }

    @GetMapping("byUni/{uniID}")
    public List<Course> getCourseByUniId(@PathVariable("uniID") long uniID) {
        return courseSrevice.findCoursesByUniID(uniID);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveOrUpdateCourse(@RequestBody Course Course) {
        courseSrevice.saveOrUpdateCourse(Course);
        return new ResponseEntity("Course Added Successfully", HttpStatus.OK);
    }
}
