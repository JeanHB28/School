package com.School.app.service;

import java.util.List;

public interface BaseServiceStudentTask<T> {
    public boolean Add(long student_Id, long tasks_id);

    public T GetById(long id);

    public List<T> ShowAll();

    public boolean Update(long student_Id, long tasks_id, long studentTask_id);

    public boolean Delete(long id);
}
