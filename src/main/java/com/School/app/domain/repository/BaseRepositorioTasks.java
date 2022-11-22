package com.School.app.domain.repository;
import com.School.app.domain.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepositorioTasks extends JpaRepository<Tasks, Long> {
}
