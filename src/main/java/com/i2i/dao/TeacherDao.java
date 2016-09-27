package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Student;
import com.i2i.model.Teacher;
import com.i2i.model.User;

/**
 * <p>
 * DataAccessObject(Dao) which is used to perform create, retrieve, retrieve all, delete operations for model Teacher
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Zeeshan
 * 
 * @created 2016-09-07
 */
public interface TeacherDao extends GenericDao<Teacher, Long> {
    
	/**
     * Saves the teacher to the database by passing it
     * 
     * @param teacher
     *     teacher is a person who teaches in school
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     *     
     */
    public void insertTeacher(Teacher teacher, User user) throws DatabaseException;    
        
    /**
     * Retrieves the teacher by passing id of the teacher
     * 
     * @param id
     *     id of the teacher whose record has to be viewed
     * @return teacher
     *     teacher is a person who teaches in school
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public Teacher findTeacherById(int id) throws DatabaseException; 

    /**
     * Deletes the teacher by passing teacherId 
     * 
     * @param teacherId
     *     id of the teacher to delete
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public void deleteTeacherById(int id) throws DatabaseException; 
        
    /**
     * Edits the teacher details by accessing the database.
     * 
     * @param teacher
     *     teacher is a person who teaches in school
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public void editTeacher(Teacher teacher) throws DatabaseException; 
        
    /**
     * Retrieves  the list of teachers from the database
     * 
     * @return teachers
     *     List of teachers
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public List<Teacher> retrieveTeachers() throws DatabaseException; 
}
