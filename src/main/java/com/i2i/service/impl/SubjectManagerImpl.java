package com.i2i.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.dao.StudentDao;
import com.i2i.dao.SubjectDao;
import com.i2i.model.Student;
import com.i2i.model.Subject;
import com.i2i.model.Teacher;
import com.i2i.service.StudentService;
import com.i2i.service.SubjectService;
import com.i2i.service.TeacherService;
import com.i2i.exception.DatabaseException;
    
/**
 * <p>
 * Service which is used to perform basic create update, retrieve, retrieve all and delete operations
 *  for model Subject by invoking SubjectDao class methods
 * </p>
 * 
 * @author Manigandan
 * 
 * @created 2016-09-08
 */
@Service("subjectService")
public class SubjectManagerImpl extends GenericManagerImpl<Subject, Long> implements SubjectService {
    private SubjectDao subjectDao;
    private TeacherService teacherService;
    
    @Autowired
    public SubjectManagerImpl(SubjectDao subjectDao, TeacherService teacherService) {
    	super(subjectDao);
    	this.subjectDao = subjectDao;
        this.teacherService = teacherService;
    }
        
    /**
     * Calls the SubjectDao class method to add the subject to the database by passing the subject
     * 
     * @param subject
     *     subject is a branch of knowledge that is taught to students
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void addSubject(Subject subject) throws DatabaseException {                 
    	subjectDao.insertSubject(subject);                     
    }
    
    /**
     * <p>
     * Invokes the SubjectDao class method to get subject using subjectCode of the subject
     * Returns the subject
     * </p>
     * 
     * @param subjectCode
     *     code of the subject
     * @return 
     *     Subject of the corresponding subject code    
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public Subject getSubjectBySubjectCode(String subjectCode) throws DatabaseException {
        return (subjectDao.findSubjectBySubjectCode(subjectCode));        
    }
    
    /**
     * <p>
     * Invokes the SubjectDao class method to get subject model object using teacherId
     * Returns the subject model object
     * </p>
     * 
     * @param teacherId
     *     id of teacher
     * @return 
     *     subject assigned to the particular teacher    
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public Subject getSubjectByTeacherId(int teacherId) throws DatabaseException {
        return (subjectDao.findSubjectByTeacherId(teacherId));        
    }
    
    /**
     * <p>
     * Invokes the SubjectDao class method to delete subject using subjectCode
     * </p>
     * 
     * @param subjectCode
     *     subjectCode of the subject to delete
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void removeSubjectBySubjectCode(String subjectCode) throws DatabaseException {
    	subjectDao.deleteSubjectBySubjectCode(subjectCode);  
    }
    
    /**
     * <p>
     * Invokes the SubjectDao method to edit the subject details by passing the subject
     * </p>
     * 
     * @param subject
     *     subject is a branch of knowledge that is taught to students
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void editSubject(Subject subject) throws DatabaseException {
        subjectDao.editSubject(subject);
    }
    
    /**
     * <p>
     * Invokes the SubjectDao class method to get the list of all of subjects 
     * </p>
     * @return
     *     returns the list of subjects
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<Subject> getSubjects() throws DatabaseException {
        return (subjectDao.retrieveSubjects());
    }
    
    /**
     * <p>
     * Used to allot teacher to a subject by passing the subject
     * Checks if the teacher is present by invoking the TeacherService method by passing the teacherId
     * Invokes the SubjectDao method to allot the teacher to the subject by passing the
     *  subject and teacher
     *  </p>
     *  
     * @param subject
     *     subject to which the teacher is assigned
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void allotTeacher(Subject subject) throws DatabaseException {
        Teacher teacher = new Teacher();
    	Subject allocateSubject = getSubjectBySubjectCode(subject.getSubjectCode());
    	int teacherId = subject.getTeacher().getTeacherId();
    	if (0 != teacherId) {
            teacher = teacherService.getTeacherById(teacherId);        	
        } else {
            teacher = null;
        }
        subjectDao.updateSubjectByTeacher(allocateSubject, teacher);
    }
}