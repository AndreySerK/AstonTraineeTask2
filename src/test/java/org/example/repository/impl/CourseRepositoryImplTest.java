package org.example.repository.impl;

import org.example.db.ConnectionManager;
import org.example.model.Course;
import org.example.repository.CourseRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
class CourseRepositoryImplTest {

    CourseRepository courseRepository;

    @Container
    public static final PostgreSQLContainer<?> container =
            new PostgreSQLContainer<>("postgres:15")
                    .withDatabaseName("test")
                    .withUsername("test")
                    .withInitScript("db-migration.sql")
                    .withPassword("test");

    @BeforeEach
    void setUp() {
        ConnectionManager connectionManager = () -> DriverManager.getConnection(
                container.getJdbcUrl(),
                container.getUsername(),
                container.getPassword()
        );
        courseRepository = new CourseRepositoryImpl(connectionManager);
    }


    @Test
    void findById() {
        Course course = courseRepository.findById(1);

        assertEquals(1, course.getId());
    }

    @Test
    void deleteById() {
    }

    @Test
    void findAll() {
        List<Course> actualCourses = courseRepository.findAll();

        assertEquals(5,actualCourses.size());
    }

    @Test
    void save() {
    }
}