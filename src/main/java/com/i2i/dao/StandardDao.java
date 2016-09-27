package com.i2i.dao;

import java.util.List;

import com.i2i.model.Standard;
import com.i2i.model.Student;
import com.i2i.exception.DatabaseException;

/**
 * <p>
 * DataAccessObject(Dao) which is used to perform create, retrieve, retrieve all, delete operations for model Standard
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Manigandan
 * 
 * @created 2016-09-08
 */

public interface StandardDao extends GenericDao<Standard, Long> {   

    /**
     * Saves the standard to the database by passing it. It also gets the list of subjects assigned to that
     * standard and stores it as a list in the Standard 
     * 
     * @param standard
     *     It is a grade in which students are taught a set of subjects
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     *     
     */
    void insertStandard(Standard standard) throws DatabaseException; 
    
    /**
     * Deletes the standard model object by passing standardId 
     * 
     * @param standardId
     *     id of the standard to delete
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    void deleteStandardById(int id) throws DatabaseException; 
    
    /**
     * Retrieves the standard object by passing id of the standard
     * 
     * @param id
     *     id of the standard whose record has to be viewed
     * @return standard
     *    object of class Standard
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    Standard findStandardById(int id) throws DatabaseException; 
    
    /**
     * Edits the standard details by accessing the database, passing the Standard class object.
     * 
     * @param standard
     *     Standard class which is to edited
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    void updateStandard(Standard standard) throws DatabaseException; 
    
    /**
     * Retrieves  the list of standards from the database
     * 
     * @return standards
     *     ArrayList of standards
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    List<Standard> retrieveStandards() throws DatabaseException; 
}