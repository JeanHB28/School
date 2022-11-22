package com.School.app.service;


import com.School.app.domain.dto.TasksDTO;
import com.School.app.domain.entity.Tasks;
import com.School.app.domain.repository.BaseRepositorioTasks;
import com.School.app.exception.ExceptionMessage;
import com.School.app.mapper.MapperTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements BaseService<TasksDTO> {
    private static final String ID_NOT_FOOUND = "El ID %id no existe";
    private final BaseRepositorioTasks baseRepositorioTasks;
    private final MapperTask mapperTask;

    public TaskService(BaseRepositorioTasks baseRepositorioTasks, MapperTask mapperTask) {
        this.baseRepositorioTasks = baseRepositorioTasks;
        this.mapperTask = mapperTask;
    }

    @Override
    public boolean save(TasksDTO entidad) {
        baseRepositorioTasks.save(mapperTask.dtoTask(entidad));
        return true;
    }

    @Override
    public TasksDTO getById(long id) {
        return mapperTask.tasksDTO(baseRepositorioTasks.findById(id)
                .orElseThrow(() -> new ExceptionMessage(ID_NOT_FOOUND)));
    }

    @Override
    public List<TasksDTO> showAll() {
        List<Tasks> tasksLis = baseRepositorioTasks.findAll();
        if (tasksLis.isEmpty()) {
            throw new ExceptionMessage("La lista no tiene elementos.");
        }
        return mapperTask.tasksDTOList(tasksLis);
    }

    @Override
    public boolean update(TasksDTO entidad, long id) {
        TasksDTO dtotasks = getById(id);
        dtotasks.setName(entidad.getName());
        baseRepositorioTasks.save(mapperTask.dtoTask(dtotasks));
        return true;
    }

    @Override
    public boolean delete(long id) {
        baseRepositorioTasks.deleteById(getById(id).getId());
        return true;
    }
}
