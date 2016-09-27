package com.i2i.service.impl;

import java.util.List;

import com.i2i.dao.TeacherDao;
import com.i2i.model.Teacher;
import com.i2i.service.TeacherService;
import com.i2i.exception.DatabaseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Service which is used to perform basic create update, retrieve, retrieve all and delete operations
 * for model Role by invoking StandardDao class methods
 * </p>
 * 
 * @author Manigandan
 * 
 * @created 2016-09-08
 */
@Service("teacherService")
public class TeacherManagerImpl extends GenericManagerImpl<Teacher, Long> implements TeacherService {
    TeacherDao teacherDao;

    @Autowired
    public TeacherManagerImpl(TeacherDao teacherDao) {
        super(teacherDao);
        this.teacherDao = teacherDao;
    }

    /**
     * Calls the TeacherDao class method to add the standard to the database by passing the Teacher class object
     * 
     * @param teacher
     *     object of class Teacher
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void addTeacher(Teacher teacher) throws DatabaseException {                 
        teacherDao.insertTeacher(teacher);                    
    }
    
    /**
     * Returns the teacher model object by passing the id of teacher
     * 
     * @param id
     *     id of teacher
     * @return
     *     object of class Teacher
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public Teacher getTeacherById(int id) throws DatabaseException {
    	return (teacherDao.findTeacherById(id));        
    }
    
    /**
     * Invokes the TeacherDao class method to delete teacher using id
     * 
     * @param id
     *     id of the teacher to delete
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void removeTeacherById(int id) throws DatabaseException {
    	teacherDao.deleteTeacherById(id);  
    }
    
    /**
     * Invokes the teacherDao method to edit the teacher details by passing the Teacher class object
     * 
     * @param teacher
     *     object of Teacher class
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void editTeacher(Teacher teacher) throws DatabaseException {
        teacherDao.editTeacher(teacher);
    }
    
    /**
     * Invokes the TeacherDao class method to get the list of all of teachers
     *  
     * @return 
     *     list of teachers returned in List datatype
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<Teacher> getTeachers() throws DatabaseException {
        return (teacherDao.retrieveTeachers());
    }
}