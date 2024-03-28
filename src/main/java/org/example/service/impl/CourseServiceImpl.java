package org.example.service.impl;

import org.example.model.Course;
import org.example.repository.CourseRepository;
import org.example.repository.impl.CourseRepositoryImpl;
import org.example.service.CourseService;

import java.util.List;
import java.util.UUID;

public class CourseServiceImpl implements CourseService {

    CourseRepository repository = new CourseRepositoryImpl();

    @Override
    public Course save(Course course) {
        return null;
    }

    @Override
    public Course findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Course deleteById(int id) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }
}
