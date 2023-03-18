package com.lab2.lab2.Dao;

import com.lab2.lab2.Entity.Student;

import java.util.List;

public interface StudentDao {
    void add(Student student);
    void modify(Student student);

    void remove(String sid);

    Student getById(String sid);
    List<Student> getAll(String sql);

}
