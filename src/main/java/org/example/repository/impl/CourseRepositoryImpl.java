package org.example.repository.impl;

import org.example.db.ConnectionManager;
import org.example.db.ConnectionManagerImpl;
import org.example.model.Course;
import org.example.repository.CourseRepository;
import org.example.repository.mapper.CourseResultSetMapper;
import org.example.repository.mapper.CourseResultSetMapperImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CourseRepositoryImpl implements CourseRepository {
    private CourseResultSetMapper resultSetMapper = new CourseResultSetMapperImpl();
    private ConnectionManager connectionManager = new ConnectionManagerImpl();
    ResultSet resultSet;

    @Override
    public Course findById(Integer id) {
        // Здесь используем try with resources
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT id, course_name, study_year FROM courses WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            return resultSetMapper.map(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM courses WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM courses")) {
            resultSet = preparedStatement.executeQuery();
            return resultSetMapper.listMap(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course save(Course course) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO courses (course_name, study_year) values (?,?)")) {
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setInt(2, course.getStudyYear());
            resultSet = preparedStatement.executeQuery();
            return resultSetMapper.map(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
