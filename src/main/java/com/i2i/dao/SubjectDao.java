package com.i2i.dao;

import java.util.List;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Subject;
import com.i2i.model.Teacher;

/**
 * <p>
 * DataAccessObject(Dao) which is used to perform create, retrieve, retrieve all, delete operations for model subject
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Manigandan
 * 
 * @created 2016-09-08
 */
public interface SubjectDao extends GenericDao<Subject, Long> {
        
    /**
     * Saves the subject model object to the database by passing the Subject
     * 
     * @param subject
     *     subject is a branch of knowledge taught to students in a standard
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     *     
     */
    void insertSubject(Subject subject) throws DatabaseException; 
    
    /**
     * Retrieves the subject object by passing subject code of the subject
     * 
     * @param subjectCode
     *     code of the subject whose record has to be viewed
     * @return subject
     *    subject is a branch of knowledge taught to students in a standard
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    Subject findSubjectBySubjectCode(String subjectCode) throws DatabaseException; 
    
    /**
     * Retrieves the subject object by passing subject code of the subject
     * 
     * @param teacher id
     *     id of teacher whose record has to be viewed
     * @return subject
     *    object of class Subject
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    Subject findSubjectByTeacherId(int teacherId) throws DatabaseException; 
    
    /**
     * Deletes the subject model object by passing subjectcode 
     * @param subjectCode
     *     code of the subject
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    void deleteSubjectBySubjectCode(String subjectCode) throws DatabaseException; 
    
    /**
     * Edits the subject details by accessing the database, passing the Subject class object.
     * 
     * @param subject
     *     object of Subject class to edit
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    void editSubject(Subject subject) throws DatabaseException; 
    
    /**
     * Retrieves  the list of subjects from the database
     * 
     * @return subjects
     *     List of subjects
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    List<Subject> retrieveSubjects() throws DatabaseException; 
    
    /**
     * The method is used to assign a teacher to a subject by passing the objects of Subject and Teacher class
     * 
     * @param subject
     *     object of class Subject
     * @param teacher
     *     object of class Teacher
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    void updateSubjectByTeacher(Subject subject, Teacher teacher) throws DatabaseException; 
}
