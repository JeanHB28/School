package com.School.app.domain.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class StudentDTO {
    private long id;

    private String name;

    private String lastName;

    private String tuition;
}
