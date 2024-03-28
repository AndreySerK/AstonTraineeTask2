package org.example.model;


import java.util.List;

public class University {

    private int id;
    private String name;
    private String city;
    private List<Student> students;
    private List<Course> courses;

    public University() {
    }

    public University(int id, String name, String city, List<Student> students, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.students = students;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
