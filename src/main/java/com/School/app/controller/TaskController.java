package com.School.app.controller;

import com.School.app.domain.dto.TasksDTO;
import com.School.app.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final BaseService<TasksDTO> baseService;


    public TaskController(BaseService<TasksDTO> baseService) {
        this.baseService = baseService;
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody TasksDTO tasksDTO) {
        baseService.save(tasksDTO);
    }

    @GetMapping(value = "/showAll")
    public List<TasksDTO> showAll() {
        return baseService.showAll();
    }

    @GetMapping(value = "/getByID/{id}")
    public TasksDTO getById(@PathVariable long id) {
        return baseService.getById(id);
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable long id, @RequestBody TasksDTO tasksDTO) {
        baseService.update(tasksDTO, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable long id) {
        baseService.delete(id);
    }
}
