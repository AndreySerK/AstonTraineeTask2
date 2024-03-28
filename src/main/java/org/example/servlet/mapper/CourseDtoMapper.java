package org.example.servlet.mapper;


import org.example.model.Course;
import org.example.servlet.dto.CourseDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseDtoMapper {

    Course toEntity(CourseDto dto);

    CourseDto toDto(Course course);
}
