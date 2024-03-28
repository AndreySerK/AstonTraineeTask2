package org.example.repository.mapper;

import org.example.model.Course;

import java.sql.ResultSet;
import java.util.List;

public interface CourseResultSetMapper {
    Course map(ResultSet resultSet);
    List<Course> listMap(ResultSet resultSet);
}
