package com.School.app.service;

import com.School.app.domain.dto.StudentTaskDTO;
import com.School.app.domain.entity.StudentTask;
import com.School.app.domain.repository.BaseRepositorioStudent;
import com.School.app.domain.repository.BaseRepositorioStudentTask;
import com.School.app.domain.repository.BaseRepositorioTasks;
import com.School.app.exception.ExceptionMessage;
import com.School.app.mapper.StudentTaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentTaskService implements BaseServiceStudentTask<StudentTaskDTO> {
    private static final String ID_NOT_FOOUND = "El ID %id no existe";
    private final BaseRepositorioStudent baseRepositorioStudent;
    private final BaseRepositorioTasks baseRepositorioTasks;
    private final BaseRepositorioStudentTask baseRepositorioStudentTask;
    private final StudentTaskMapper studentTaskMapper;

    public StudentTaskService(BaseRepositorioStudent baseRepositorioStudent, BaseRepositorioTasks baseRepositorioTasks, BaseRepositorioStudentTask baseRepositorioStudentTask, StudentTaskMapper studentTaskMapper) {
        this.baseRepositorioStudent = baseRepositorioStudent;
        this.baseRepositorioTasks = baseRepositorioTasks;
        this.baseRepositorioStudentTask = baseRepositorioStudentTask;
        this.studentTaskMapper = studentTaskMapper;
    }

    @Override
    public boolean Add(long student_Id, long tasks_id) {
        baseRepositorioStudentTask.save(
                StudentTask.builder()
                        .student(baseRepositorioStudent.getReferenceById(student_Id))
                        .tasks(baseRepositorioTasks.getReferenceById(tasks_id))
                        .build());

        return true;
    }

    @Override
    public StudentTaskDTO GetById(long id) {
        return studentTaskMapper.DTOstudentTask(baseRepositorioStudentTask.findById(id)
                .orElseThrow(() -> new ExceptionMessage(ID_NOT_FOOUND)));
    }

    @Override
    public List<StudentTaskDTO> ShowAll() {
        List<StudentTask> studentTasks = baseRepositorioStudentTask.findAll()
                .stream()
                .filter(studentTask -> studentTask.getStudent() != null && studentTask.getTasks() != null)
                .collect(Collectors.toList());

        if (studentTasks.isEmpty()) {
            throw new ExceptionMessage("La lista no tiene elementos.");
        }
        return studentTaskMapper.StudentDTOList(studentTasks);
    }

    @Override
    public boolean Update(long studentTask_id, long student_Id, long tasks_id) {
        StudentTask studentTask = baseRepositorioStudentTask.findById(studentTask_id)
                .orElseThrow(() -> new ExceptionMessage(ID_NOT_FOOUND));
        studentTask.setStudent(baseRepositorioStudent.getReferenceById(student_Id));
        studentTask.setTasks(baseRepositorioTasks.getReferenceById(tasks_id));
        baseRepositorioStudentTask.save(studentTask);


        return true;
    }

    @Override
    public boolean Delete(long id) {

        baseRepositorioStudentTask.deleteById(GetById(id).getId());
        return true;
    }

    public boolean VerifyDelete(StudentTask studentTask) {
        List<StudentTask> studentTasks = baseRepositorioStudentTask.findAll();
        for (StudentTask stu : studentTasks) {
            if (stu.getStudent().isDeleted() || stu.getTasks().isDeleted()) {
                return true;
            }
        }
        return false;
    }
}
