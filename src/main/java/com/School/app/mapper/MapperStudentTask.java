package com.School.app.mapper;

import com.School.app.domain.dto.StudentTaskDTO;
import com.School.app.domain.entity.StudentTask;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperStudentTask implements StudentTaskMapper {
    public final MapperStudent mapperStudent;
    public final MapperTask mapperTask;

    public MapperStudentTask(MapperStudent mapperStudent, MapperTask mapperTask) {
        this.mapperStudent = mapperStudent;
        this.mapperTask = mapperTask;
    }


    @Override
    public StudentTask tudentTaskDTO(StudentTaskDTO studentTaskDTO) {
        return StudentTask.builder()
                .id(studentTaskDTO.getId())
                .student(mapperStudent.dtostudent(studentTaskDTO.getStudentDTO()))
                .tasks(mapperTask.dtoTask(studentTaskDTO.getTasksDTO()))
                .build();
    }

    @Override
    public StudentTaskDTO DTOstudentTask(StudentTask studentTask) {
        return StudentTaskDTO.builder()
                .id(studentTask.getId())
                .studentDTO(mapperStudent.studentDTOst(studentTask.getStudent()))
                .tasksDTO(mapperTask.tasksDTO(studentTask.getTasks()))
                .build();
    }

    @Override
    public List<StudentTaskDTO> StudentDTOList(List<StudentTask> studentTask) {
        List<StudentTaskDTO>studentTaskDTOSlist = new ArrayList<>();
        for (StudentTask studentTasks:studentTask) {
            studentTaskDTOSlist.add(DTOstudentTask(studentTasks));
        }
        return studentTaskDTOSlist;
    }
}
