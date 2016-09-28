package com.i2i.service.impl;

import com.i2i.dao.StudentDao;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Student;
import com.i2i.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentManagerImpl extends GenericManagerImpl<Student, Long> implements StudentService {
    StudentDao studentDao;

    @Autowired
    public StudentManagerImpl(StudentDao studentDao) {
        super(studentDao);
        this.studentDao = studentDao;
    }
    
    /**
     * <p>
     * Adds the student by invoking the dao method
     * </p>
     */
    public void addStudent(Student student) throws DatabaseException {                 
        studentDao.insertStudent(student);                     
    }
    
    /**
     * <p>
     * Gets the student by passing the student id and invoking the dao method 
     * </p>
     */
    public Student getStudentById(int id) throws DatabaseException {
        return (studentDao.findStudentById(id));        
    }
    
    /**
     * <p>
     * Deletes the student by passing the id to the dao method
     * </p>
     */
    public void removeStudentById(int id) throws DatabaseException {
        studentDao.deleteStudentById(id);  
    }
    
    /**
     * <p>
     * Edits the student details by passing the student to the dao
     * </p>
     */
    public void editStudent(Student student) throws DatabaseException {
        studentDao.editStudent(student);
    }
    
    /**
     * <p>
     * Gets the list of all students by invoking the dao method
     * </p>
     */
    public List<Student> getStudents() throws DatabaseException {
        return (studentDao.retrieveStudents());
    }
}
