package com.School.app.mapper;


import com.School.app.domain.dto.StudentTaskDTO;
import com.School.app.domain.entity.StudentTask;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StudentTaskMapper {
    StudentTask tudentTaskDTO(StudentTaskDTO studentTaskDTO);

    StudentTaskDTO DTOstudentTask(StudentTask studentTask);

    List<StudentTaskDTO> StudentDTOList(List<StudentTask> studentTask);
}
