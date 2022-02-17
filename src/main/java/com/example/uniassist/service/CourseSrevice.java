package com.example.uniassist.service;

import com.example.uniassist.model.Course;

import java.util.List;

public interface CourseSrevice {
    Course findCourseByCourseId(long courseId);
    List<Course> findCoursesByUniID(long uniID);
    Course saveOrUpdateCourse(Course Course);
}
