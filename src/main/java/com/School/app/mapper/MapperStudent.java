package com.School.app.mapper;

import com.School.app.domain.dto.StudentDTO;
import com.School.app.domain.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperStudent implements studentMapper {
    @Override
    public Student dtostudent(StudentDTO studentDTO) {
        return Student.builder()
                .name(studentDTO.getName())
                .lastName(studentDTO.getLastName())
                .tuition(studentDTO.getTuition()).build();
    }

    @Override
    public StudentDTO studentDTOst(Student student) {

        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .lastName(student.getLastName())
                .tuition(student.getTuition()).build();
    }

    public List<StudentDTO> StudentDTOList(List<Student> student) {
        List<StudentDTO> studentlist = new ArrayList<>();
        for (Student list : student) {
            studentlist.add(studentDTOst(list));
        }
        return studentlist;
    }
}
