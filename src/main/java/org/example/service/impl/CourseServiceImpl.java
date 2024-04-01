package org.example.service.impl;

import org.example.model.Course;
import org.example.repository.CourseRepository;
import org.example.repository.impl.CourseRepositoryImpl;
import org.example.service.CourseService;
import org.example.service.SimpleService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    CourseRepository repository = new CourseRepositoryImpl();

    @Override
    public void save(Course course) {
        repository.save(course);
    }

    @Override
    public Course findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public boolean deleteById(Integer id) {
        return repository.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }
}
