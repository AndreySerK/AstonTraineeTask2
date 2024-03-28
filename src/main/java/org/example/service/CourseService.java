package org.example.service;

import org.example.model.Course;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    Course save(Course course);

    Course findById(int id);

    Course deleteById(int id);

    List<Course> findAll();
}
