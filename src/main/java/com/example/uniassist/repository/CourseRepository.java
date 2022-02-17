package com.example.uniassist.repository;

import com.example.uniassist.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course, Long> {

    Course findCourseByCourseId(long courseId);
    List<Course> findCoursesByUniID(long uniID);
}
