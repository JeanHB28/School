package com.School.app.mapper;

import com.School.app.domain.dto.TasksDTO;
import com.School.app.domain.entity.Tasks;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface tasksMapper {
    Tasks dtoTask(TasksDTO tasksDTO);

    TasksDTO tasksDTO(Tasks tasks);

    List<TasksDTO> tasksDTOList(List<Tasks> tasks);
}
