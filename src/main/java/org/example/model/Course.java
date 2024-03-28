package org.example.model;

import java.util.Set;

public class Course {
    private Integer id;
    private String courseName;
    private int studyYear;
    private Set<Student> students;
    private University university;

    public Course() {}

    public Course(Integer id, String name, int studyYear, Set<Student> students, University university) {
        this.id = id;
        this.courseName = name;
        this.studyYear = studyYear;
        this.students = students;
        this.university = university;
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

    public Set<Student> getStudents() {
        return students;
    }

    public University getUniversity() {
        return university;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
