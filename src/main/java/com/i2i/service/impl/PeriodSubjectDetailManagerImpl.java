package com.i2i.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.exception.DatabaseException;
import com.i2i.model.PeriodSubjectDetail;
import com.i2i.model.Standard;
import com.i2i.model.Student;
import com.i2i.model.Subject;
import com.i2i.service.PeriodSubjectDetailService;
import com.i2i.service.StandardService;
import com.i2i.service.StudentService;
import com.i2i.dao.PeriodSubjectDetailDao;
import com.i2i.dao.StudentDao;
import com.i2i.Constants;

/**
 * <p>
 * Service which is used to generate the time table of standard
 * </p>
 * 
 * @author Manigandan
 * 
 * @created 2016-09-15
 */
@Service("periodSubjectDetailService")
public class PeriodSubjectDetailManagerImpl extends GenericManagerImpl<PeriodSubjectDetail, Long> implements PeriodSubjectDetailService {
    private PeriodSubjectDetailDao periodSubjectDetailDao;
    private StandardService standardService;
	
    @Autowired
    public PeriodSubjectDetailManagerImpl(PeriodSubjectDetailDao periodSubjectDetailDao, StandardService standardService) {
        super(periodSubjectDetailDao);
        this.periodSubjectDetailDao = periodSubjectDetailDao;
        this.standardService = standardService;
    }
    
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
    public void generateTimeTable(int standardId) throws DatabaseException {
        Standard standard = standardService.getStandardById(standardId);
        List<Subject> subjects = standard.getSubjects();                    
        generatePeriods(allocateSubjectToPeriod(subjects));        
    }	
	
    /**
     * Gets the list of subjects of standard and generate the list of periods with subject code
     * 
     * @param subjects
     *     subjects holds the list of subjects
     * @return periods
     *     periods holds the list of periods with subject code       
     */
    public List<Subject> allocateSubjectToPeriod(List<Subject> subjects) {
    	PeriodSubjectDetail periodSubjectDetail = new PeriodSubjectDetail(); 
    	return (periodSubjectDetail.addSubjects(subjects));
    }        
	
    /**
     * Gets the list of periods with period id as index and generate the list of PeriodSubjectDetail objects then return it
     * 
     * @param periods
     *     periods holds the list of periods with subject code 
     * @return periodSubjectDetails
     *     periodSubjectDetails holds the list of periods with subject code, teacher id and standard id       
     */
    public void generatePeriods(List<Subject> periods) throws DatabaseException {
       	PeriodSubjectDetail periodSubjectDetail = new PeriodSubjectDetail();        
        int i = 1;			
	while (i<= Constants.NUMBER_OF_PERIODS) {
	    Subject subject = periods.get(i);				
	    periodSubjectDetail.setPeriodId(i);				
	    periodSubjectDetail.setSubjectCode(subject.getSubjectCode());				
	    periodSubjectDetail.setStandard(subject.getStandard());
	    periodSubjectDetail.setTeacher(subject.getTeacher());	    
	    periodSubjectDetailDao.insertPeriodSubjectDetail(periodSubjectDetail);   
	    i++;												
        }	
    }	 
    
    /**
     * Gets the standard id whose time table has to be retrieved and sends to PeriodSubjectDetail Dao    
     * 
     * @param standardId
     *     standardId holds the id of standard for which the periods have to be retrieved
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<PeriodSubjectDetail> getPeriodSubjectDetailsByStandardId(int standardId) throws DatabaseException {
    	return (periodSubjectDetailDao.retrievePeriodSubjectDetailsByStandardId(standardId));        
    }
    
    /**
     * Gets the teacher id whose time table has to be retrieved and sends to PeriodSubjectDetail Dao    
     * 
     * @param teacherId
     *     teacherId holds the id of teacher for which the periods have to be retrieved
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<PeriodSubjectDetail> getPeriodSubjectDetailsByTeacherId(int teacherId) throws DatabaseException {
    	List<PeriodSubjectDetail> teacherPeriods = new ArrayList<PeriodSubjectDetail>();
    	List<PeriodSubjectDetail> periodSubjectDetails = periodSubjectDetailDao.retrievePeriodSubjectDetailsByTeacherId(teacherId);
    	PeriodSubjectDetail periodSubjectDetail = null;
    	int i = 0;			
	while (i<= Constants.NUMBER_OF_PERIODS) {		    
	    teacherPeriods.add(periodSubjectDetail);			
	    i++;												
        }		
    	teacherPeriods.add(periodSubjectDetails.get(0).getPeriodId(),periodSubjectDetails.get(0));    	
    	teacherPeriods.add(periodSubjectDetails.get(1).getPeriodId(),periodSubjectDetails.get(1));    	
    	teacherPeriods.add(periodSubjectDetails.get(2).getPeriodId(),periodSubjectDetails.get(2));    	
    	teacherPeriods.add(periodSubjectDetails.get(3).getPeriodId(),periodSubjectDetails.get(3));
    	return (teacherPeriods);        
    }    
}
