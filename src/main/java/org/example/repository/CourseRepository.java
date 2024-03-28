package org.example.repository;

import org.example.db.ConnectionManagerImpl;
import org.example.model.Course;

import java.util.UUID;

public interface CourseRepository extends SimpleRepository<Course, Integer>{
}
