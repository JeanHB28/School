package com.School.app.service;

public interface UserService<T> {

    public boolean save(T entity);

    public T finByEmail(String email);

}
