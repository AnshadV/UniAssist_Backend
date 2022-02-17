package com.example.uniassist.service.impl;

import com.example.uniassist.model.Course;
import com.example.uniassist.repository.CourseRepository;
import com.example.uniassist.service.CourseSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseSrevice {

    @Autowired
    private  CourseRepository CourseRepository;


    @Override
    public Course findCourseByCourseId(long courseId) {
        return CourseRepository.findCourseByCourseId(courseId);
    }

    @Override
    public List<Course> findCoursesByUniID(long uniID) {
        return CourseRepository.findCoursesByUniID(uniID);
    }

    @Override
    public Course saveOrUpdateCourse(Course Course) {
        return CourseRepository.save(Course);
    }


}
