package com.i2i.service;

import com.i2i.model.Student;
import com.i2i.exception.DatabaseException;

import java.util.List;

public interface StudentService extends GenericManager<Student, Long> {
    
    void addStudent(Student student) throws DatabaseException;

    Student getStudentById(int id) throws DatabaseException;

    void removeStudentById(int id) throws DatabaseException;

    void editStudent(Student student) throws DatabaseException;

    List<Student> getStudents() throws DatabaseException;
}    
