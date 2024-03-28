package org.example.model;

import java.util.List;

public class Course {
    private Integer id;
    private String courseName;
    private int studyYear;
    private List<Student> students;
    private int universityId;

    public Course() {}

    public Course(Integer id, String name, int studyYear, List<Student> students, int university) {
        this.id = id;
        this.courseName = name;
        this.studyYear = studyYear;
        this.students = students;
        this.universityId = university;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }
}
