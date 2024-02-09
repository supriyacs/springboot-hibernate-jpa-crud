package com.SCS.cruddemo.dao;

import com.SCS.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void Save(Student student);
    Student findByID(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);
    void update(Student student);
}
