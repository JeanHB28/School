package com.School.app.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component

public class StudentTaskDTO {

    private long id;

    private StudentDTO studentDTO;

    private TasksDTO tasksDTO;
}
