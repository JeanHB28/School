package com.School.app.controller;

import com.School.app.domain.dto.StudentTaskDTO;
import com.School.app.service.BaseServiceStudentTask;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/StudentTask")
public class StudentTaskController {
    private final BaseServiceStudentTask<StudentTaskDTO> baseServiceStudentTask;

    public StudentTaskController(BaseServiceStudentTask<StudentTaskDTO> baseServiceStudentTask) {
        this.baseServiceStudentTask = baseServiceStudentTask;
    }

    @PostMapping(value = "/save/{student_id}/{task_id}")
    public void save(@PathVariable long student_id, @PathVariable long task_id) {
        baseServiceStudentTask.Add(student_id, task_id);
    }

    @GetMapping(value = "/showAll")
    public List<StudentTaskDTO> showAll() {
        return baseServiceStudentTask.ShowAll();
    }

    @GetMapping(value = "/GetById/{id}")
    public StudentTaskDTO GetById(@PathVariable long id) {
        return baseServiceStudentTask.GetById(id);
    }

    @PutMapping(value = "/update/{studentTask_id}/{student_id}/{task_id}")
    public void update(@PathVariable long studentTask_id, @PathVariable long student_id, @PathVariable long task_id) {
        baseServiceStudentTask.Update(studentTask_id, student_id, task_id);
    }

    @DeleteMapping(value = "/delete/{studentTask_id}")
    public void delete(@PathVariable long studentTask_id) {
        baseServiceStudentTask.Delete(studentTask_id);
    }

}
