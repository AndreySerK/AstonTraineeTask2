package org.example.servlet.dto;


public class CourseDto {

    private String courseName;
    private int studyYear;

    public CourseDto() {
    }

    public CourseDto(String courseName, int studyYear) {
        this.courseName = courseName;
        this.studyYear = studyYear;
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
}
