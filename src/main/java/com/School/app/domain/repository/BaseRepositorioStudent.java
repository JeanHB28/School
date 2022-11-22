package com.School.app.domain.repository;

import com.School.app.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepositorioStudent extends JpaRepository<Student, Long> {

}
