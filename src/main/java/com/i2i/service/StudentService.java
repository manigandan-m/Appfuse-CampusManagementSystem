package com.i2i.service;

import java.util.List;

/*import com.i2i.model.Standard;*/
import com.i2i.model.Student;
/*import com.i2i.model.User;*/
import com.i2i.exception.DatabaseException;

/**
  * <p>
  * Service which is used to perform basic create update, retrieve, retrieve all and delete operations
  * for model Role by invoking StudentDao class methods
  * </p>
  * 
  * @author Zeeshan Ali
  * 
  * @created 2016-09-07
  */
public interface StudentService extends GenericManager<Student, Long> {
        
    /**
     * Calls the StudentDao class method to add the standard to the database by passing the Student class object
     * 
     * @param student
     *     student is a person who is pupil in a school
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    //void addStudent(Student student, User user, Standard standard) throws DatabaseException; 
    void addStudent(Student student) throws DatabaseException; 
    
    /**
     * Returns the student model object by passing the id of student
     * 
     * @param id
     *     id of student
     * @return
     *     student
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    Student getStudentById(int id) throws DatabaseException;
    
    /**
     * Invokes the StudentDao class method to delete student using id
     * 
     * @param id
     *     id of the student to delete
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    void removeStudentById(int id) throws DatabaseException;
    
    /**
     * Invokes the studentDao method to edit the student details by passing the Student class object
     * 
     * @param student
     *     student is a person who is pupil in a school
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    void editStudent(Student student) throws DatabaseException; 
    
    /**
     * Invokes the StudentDao class method to get the list of all of students
     *  
     * @return 
     *     list of students returned
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    List<Student> getStudents() throws DatabaseException; 
}