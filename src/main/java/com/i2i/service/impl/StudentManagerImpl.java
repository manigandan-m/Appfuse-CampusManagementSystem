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

    public void addStudent(Student student) throws DatabaseException {                 
        studentDao.insertStudent(student);                     
    }

    public Student getStudentById(int id) throws DatabaseException {
        return (studentDao.findStudentById(id));        
    }

    public void removeStudentById(int id) throws DatabaseException {
        studentDao.deleteStudentById(id);  
    }

    public void editStudent(Student student) throws DatabaseException {
        studentDao.editStudent(student);
    }

    public List<Student> getStudents() throws DatabaseException {
        return (studentDao.retrieveStudents());
    }
}