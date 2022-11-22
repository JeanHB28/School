package com.School.app.mapper;


import com.School.app.domain.dto.TasksDTO;
import com.School.app.domain.entity.Tasks;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperTask implements tasksMapper {

    @Override
    public Tasks dtoTask(TasksDTO tasksDTO) {
        return Tasks.builder()
                .name(tasksDTO.getName())
                .build();
    }

    @Override
    public TasksDTO tasksDTO(Tasks tasks) {
        return TasksDTO.builder()
                .id(tasks.getId())
                .name(tasks.getName())
                .build();
    }

    @Override
    public List<TasksDTO> tasksDTOList(List<Tasks> tasks) {
        List<TasksDTO> tasksDTOList = new ArrayList<>();
        for (Tasks task : tasks) {
            tasksDTOList.add(tasksDTO(task));
        }
        return tasksDTOList;
    }
}
