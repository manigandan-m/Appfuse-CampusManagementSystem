package com.i2i.dao;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Student;

import java.util.List;

public interface StudentDao extends GenericDao<Student, Long> {

    void insertStudent(Student student) throws DatabaseException;
    
    Student findStudentById(int id) throws DatabaseException;

    void deleteStudentById(int id) throws DatabaseException;

    void editStudent(Student student) throws DatabaseException;

    List<Student> retrieveStudents() throws DatabaseException;
}