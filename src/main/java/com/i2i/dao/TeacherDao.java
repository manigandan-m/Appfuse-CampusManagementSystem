package com.i2i.dao;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Teacher;

import java.util.List;

public interface TeacherDao extends GenericDao<Teacher, Long> {

    void insertTeacher(Teacher teacher) throws DatabaseException; 
    
    Teacher findTeacherById(int id) throws DatabaseException;

    void deleteTeacherById(int id) throws DatabaseException;

    public void editTeacher(Teacher teacher) throws DatabaseException;

    List<Teacher> retrieveTeachers() throws DatabaseException;
}