package com.School.app.controller;

import com.School.app.domain.dto.StudentDTO;
import com.School.app.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {
    private final BaseService<StudentDTO> baseService;

    public StudentController(BaseService<StudentDTO> baseService) {
        this.baseService = baseService;
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody StudentDTO student) {
        baseService.save(student);
    }

    @GetMapping(value = "/showAll")
    public List<StudentDTO> showAll() {
        return baseService.showAll();
    }

    @GetMapping(value = "/getByID/{id}")
    public StudentDTO getById(@PathVariable long id) {
        return baseService.getById(id);
    }

    @PutMapping(value = "/update/{id}")
    public void updateStudent(@PathVariable long id, @RequestBody StudentDTO studentDTO) {
        baseService.update(studentDTO, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteStudent(@PathVariable long id) {
        baseService.delete(id);
    }
}
