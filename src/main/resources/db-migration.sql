DROP TABLE IF EXISTS courses;
CREATE TABLE courses (
                      id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                      course_name VARCHAR(255),
                      study_year INT
);

INSERT INTO courses (course_name, study_year) VALUES ('History', 2020 );
INSERT INTO courses (course_name, study_year) VALUES ('Mathematics', 2020 );
INSERT INTO courses (course_name, study_year) VALUES ('Chemistry', 2020 );