package com.School.app.service;

import com.School.app.domain.dto.StudentDTO;
import com.School.app.domain.entity.Student;
import com.School.app.domain.repository.BaseRepositorioStudent;
import com.School.app.exception.ExceptionMessage;
import com.School.app.mapper.MapperStudent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements BaseService<StudentDTO> {
    private final BaseRepositorioStudent baseRepositorioStudent;
    private final MapperStudent mapperStudent;
    private static final String ID_NOT_FOOUND = "El ID %id no existe";

    public StudentService(BaseRepositorioStudent baseRepositorioStudent, MapperStudent mapperStudent) {
        this.baseRepositorioStudent = baseRepositorioStudent;
        this.mapperStudent = mapperStudent;
    }

    @Override
    public boolean save(StudentDTO entidad) {
        baseRepositorioStudent.save(mapperStudent.dtostudent(entidad));
        return true;
    }

    @Override
    public StudentDTO getById(long id) {

        return mapperStudent.studentDTOst(baseRepositorioStudent.findById(id)
                .orElseThrow(() -> new ExceptionMessage(ID_NOT_FOOUND)));

    }

    @Override
    public List<StudentDTO> showAll() {
        List<Student> students = baseRepositorioStudent.findAll();
        if (students.isEmpty()) {
            throw new ExceptionMessage("La lista no tiene elementos.");
        }
        return mapperStudent.StudentDTOList(students);
    }

    @Override
    public boolean update(StudentDTO entidad, long id) {
        StudentDTO studentDTO = getById(id);
        studentDTO.setName(entidad.getName());
        studentDTO.setLastName(entidad.getLastName());
        studentDTO.setTuition(entidad.getTuition());
        baseRepositorioStudent.save(mapperStudent.dtostudent(studentDTO));
        return true;
    }

    @Override
    public boolean delete(long id) {
        baseRepositorioStudent.deleteById(getById(id).getId());
        return true;
    }
}
