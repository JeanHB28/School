package com.School.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE student_task SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
public class StudentTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "task_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Tasks tasks;

    private boolean deleted = Boolean.FALSE;


}
