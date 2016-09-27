package com.i2i.service;

import java.util.List;

import com.i2i.model.Standard;
import com.i2i.model.Student;
import com.i2i.exception.DatabaseException;

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
public interface StandardService extends GenericManager<Standard, Long> {
        
    /**
     * Calls the StandardDao class method to add the standard to the database by passing the Standard class object
     * 
     * @param standard
     *     Standard is a class where students study
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    void addStandard(Standard standard) throws DatabaseException; 
    
    /**
     * Invokes the StandardDao class method to get the list of all of standards
     *  
     * @return 
     *     list of standards returned in List datatype
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    List<Standard> getStandards() throws DatabaseException; 
    
    /**
     * Invokes the StandardDao class method to delete standard using id
     * 
     * @param id
     *     id of the standard to delete
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    void removeStandardById(int id) throws DatabaseException; 
    
    /**
     * Invokes the standardDao method to edit the standard details by passing the standard
     * 
     * @param standard
     *     a grade in which a group of students study
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    
    void editStandard(Standard standard) throws DatabaseException; 
    
    /**
     * Returns the standard model object by passing the id of standard
     * 
     * @param id
     *     id of standard
     * @return
     *     standard
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    Standard getStandardById(int id) throws DatabaseException; 
}