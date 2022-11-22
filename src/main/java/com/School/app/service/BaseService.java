package com.School.app.service;

import java.util.List;

public interface BaseService<T> {
    public boolean save(T entidad);

    public T getById(long id);

    public List<T> showAll();

    public boolean update(T entidad, long id);

    public boolean delete(long id);


}
