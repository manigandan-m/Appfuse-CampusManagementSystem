package com.i2i.dao;

import java.util.List;

//import com.i2i.model.Standard;
import com.i2i.model.Student;
import com.i2i.model.User;
import com.i2i.exception.DatabaseException;


/**
 * <p>
 * DataAccessObject(Dao) which is used to perform create, retrieve, retrieve all, delete operations for model Student
 * It allocates user model object to the student model object by assigning the id of user to the particular student
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Zeeshan
 * 
 * @created 2016-09-07
 */

public interface StudentDao extends GenericDao<Student, Long> {        

    /**
     * Saves the student model object to the database by passing it
     * 
     * @param student
     *     a person who studies in a standard
     * @throws DatabaseException
     *     if there is an error in saving the student like HibernateException
     *     
     */
    //void insertStudent(Student student, User user, Standard standard) throws DatabaseException; 
    void insertStudent(Student student) throws DatabaseException; 
    
    /**
     * Retrieves the student object by passing id of the student
     * 
     * @param id
     *     id of the student whose record has to be viewed
     * @return student
     *    student entity which contains the details of the student
     * @throws DatabaseException
     *     if there is an error in getting the student like HibernateException
     */
    Student findStudentById(int id) throws DatabaseException; 

    /**
     * Deletes the student model object by passing studentId 
     * 
     * @param studentId
     *     id of the student to delete
     * @throws DatabaseException
     *     if there is an error in deleting the student like HibernateException
     */
    void deleteStudentById(int id) throws DatabaseException; 
    
    /**
     * Edits the student details by accessing the database, passing the Student.
     * 
     * @param student
     *     student whose details need to be edited
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    void editStudent(Student student) throws DatabaseException; 
    
    /**
     * Retrieves  the list of students from the database
     * 
     * @return students
     *     ArrayList of students
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    List<Student> retrieveStudents() throws DatabaseException; 
}