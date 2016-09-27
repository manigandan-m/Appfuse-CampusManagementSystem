package com.i2i.service;

import com.i2i.model.Teacher;
import com.i2i.exception.DatabaseException;

import java.util.List;

public interface TeacherService extends GenericManager<Teacher, Long> {
    
    void addTeacher(Teacher teacher) throws DatabaseException;

    Teacher getTeacherById(int id) throws DatabaseException;

    void removeTeacherById(int id) throws DatabaseException;

    void editTeacher(Teacher teacher) throws DatabaseException;

    List<Teacher> getTeachers() throws DatabaseException;
}