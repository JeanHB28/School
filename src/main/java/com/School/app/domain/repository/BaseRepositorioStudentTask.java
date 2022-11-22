package com.School.app.domain.repository;

import com.School.app.domain.entity.StudentTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepositorioStudentTask extends JpaRepository<StudentTask, Long> {
}
