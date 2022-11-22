package com.School.app.mapper;

import com.School.app.domain.dto.StudentDTO;
import com.School.app.domain.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface studentMapper {
    Student dtostudent(StudentDTO studentDTO);

    StudentDTO studentDTOst(Student student);

    List<StudentDTO> StudentDTOList(List<Student> student);



}
