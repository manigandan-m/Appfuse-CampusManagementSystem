package com.i2i.dao;

import java.util.List;
import java.util.ArrayList;

import com.i2i.exception.DatabaseException;
import com.i2i.model.PeriodSubjectDetail;
import com.i2i.model.Subject;

/**
 * <p>
 * DataAccessObject(Dao) which is used to perform insert, retrieve, retrieve all, delete operations for timetable periods
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Manigandan
 * 
 * @created 2016-09-15
 */
public interface PeriodSubjectDetailDao extends GenericDao<PeriodSubjectDetail, Long> {
    
	/**
     * Saves the periods of time table in the form of PeriodSubjectDetail
     * 
     * @param periodSubjectDetail
     *     PeriodSubjectDetail holds the period of time table
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     *     
     */       
    void insertPeriodSubjectDetail(PeriodSubjectDetail periodSubjectDetail) throws DatabaseException; 
     
    /**
     * Retrieves  the list of periodsubjectdetails by standard id from the database
     *
     * @param standardId
     *     standard id whose period details have to be retrieved
     * @return periodSubjectDetails
     *     ArrayList of periodsubjectdetails
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    List<PeriodSubjectDetail> retrievePeriodSubjectDetailsByStandardId(int standardId) throws DatabaseException; 
     
    /**
     * Retrieves  the list of periodsubjectdetails by teacher id from the database
     *
     * @param teacherId
     *     teacher id whose period details have to be retrieved
     * @return periodSubjectDetails
     *     ArrayList of periodsubjectdetails
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    List<PeriodSubjectDetail> retrievePeriodSubjectDetailsByTeacherId(int teacherId) throws DatabaseException; 
}