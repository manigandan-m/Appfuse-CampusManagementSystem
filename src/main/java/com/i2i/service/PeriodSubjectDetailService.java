package com.i2i.service;

import java.util.ArrayList;
import java.util.List;

import com.i2i.exception.DatabaseException;
import com.i2i.model.PeriodSubjectDetail;
import com.i2i.model.Standard;
import com.i2i.model.Subject;

/**
 * <p>
 * Service which is used to generate the time table of standard and
 * </p>
 * 
 * @author Manigandan
 * 
 * @created 2016-09-15
 */
public interface PeriodSubjectDetailService {
    
    /**
     * <p>
     * Gets standard id whose time table has to be generated
     * Calls allocateSubjectToPeriod function to allocate subjects to periods
     * Then calls generatePeriods function to generate the period objects of timetable
     * Finally calls addPeriodSubjectDetails to store the period objects of timetable
     * </p>
     * 
     * @param standardId
     *     standardId holds the id of standard whose time table has to be generated
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException    
     */
    void generateTimeTable(int standardId) throws DatabaseException; 
	
    /**
     * Gets the list of subjects of standard and generate the list of periods with subject code
     * 
     * @param subjects
     *     subjects holds the list of subjects
     * @return periods
     *     periods holds the list of periods with subject code       
     */
    List<Subject> allocateSubjectToPeriod(List<Subject> subjects) throws DatabaseException; 
	
    /**
     * Gets the list of periods with period id as index and generate the list of PeriodSubjectDetail objects then return it
     * 
     * @param periods
     *     periods holds the list of periods with subject code 
     * @return periodSubjectDetails
     *     periodSubjectDetails holds the list of periods with subject code, teacher id and standard id       
     */
    void generatePeriods(List<Subject> periods) throws DatabaseException; 
    
    /**
     * Gets the standard id whose time table has to be retrieved and sends to PeriodSubjectDetail Dao    
     * 
     * @param standardId
     *     standardId holds the id of standard for which the periods have to be retrieved
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    List<PeriodSubjectDetail> getPeriodSubjectDetailsByStandardId(int standardId) throws DatabaseException; 
    
    /**
     * Gets the teacher id whose time table has to be retrieved and sends to PeriodSubjectDetail Dao    
     * 
     * @param teacherId
     *     teacherId holds the id of teacher for which the periods have to be retrieved
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    List<PeriodSubjectDetail> getPeriodSubjectDetailsByTeacherId(int teacherId) throws DatabaseException; 
}
