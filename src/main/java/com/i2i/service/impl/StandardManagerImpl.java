package com.i2i.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.dao.StandardDao;
import com.i2i.dao.StudentDao;
import com.i2i.model.Standard;
import com.i2i.model.Teacher;
import com.i2i.service.StandardService;
import com.i2i.service.TeacherService;
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
@Service("standardService")
public class StandardManagerImpl extends GenericManagerImpl<Standard, Long> implements StandardService {
    private StandardDao standardDao;
    
    @Autowired
    public StandardManagerImpl(StandardDao standardDao) {
        super(standardDao);
        this.standardDao = standardDao;
    }
    
    /**
     * <p>
     * Calls the StandardDao class method to add the standard to the database by passing the Standard class object
     * </p>
     * 
     * @param standard
     *     Standard is a class where students study
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void addStandard(Standard standard) throws DatabaseException {                 
            standardDao.insertStandard(standard);                     
    }         
    
    /**
     * Invokes the StandardDao class method to get the list of all of standards
     *  
     * @return 
     *     list of standards returned in List datatype
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<Standard> getStandards() throws DatabaseException {
        return (standardDao.retrieveStandards());
    }
    
    /**
     * <p>
     * Invokes the StandardDao class method to delete standard using id
     * </p>
     * 
     * @param id
     *     id of the standard to delete
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void removeStandardById(int id) throws DatabaseException {
        standardDao.deleteStandardById(id);  
    }
    
    /**
     * <p>
     * Invokes the standardDao method to edit the standard details by passing the standard
     * </p>
     * 
     * @param standard
     *     a grade in which a group of students study
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    
    public void editStandard(Standard standard) throws DatabaseException {
        standardDao.updateStandard(standard);
    }
    
    /**
     * <p>
     * Returns the standard model object by passing the id of standard
     * </p>
     * 
     * @param id
     *     id of standard
     * @return
     *     standard
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public Standard getStandardById(int id) throws DatabaseException {
        return (standardDao.findStandardById(id));        
    }
}
