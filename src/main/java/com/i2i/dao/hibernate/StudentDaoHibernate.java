package com.i2i.dao.hibernate;

import com.i2i.model.Student;
import com.i2i.dao.StudentDao;
import com.i2i.exception.DatabaseException;

import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository("studentDao")
@Transactional
public class StudentDaoHibernate extends GenericDaoHibernate<Student, Long> implements StudentDao {
    /**
     * Constructor to create a Generics-based version using Student as the entity
     */
    public StudentDaoHibernate() {
        super(Student.class);
    }

    /**
     * <p>
     * Gets the student details by passing the id of the student
     * </p>
     */
    public Student findStudentById(int id) throws DatabaseException {
        try {
            Session session = getSession();                           
            Student student = (Student) session.get(Student.class, id);            
            if (null == student) {
                throw new DatabaseException("Invalid student Id");
            }                     
            return student;
        } catch (HibernateException e) {                        
            throw new DatabaseException("Entered student is not found. Kindly try again with vaild input data", e);
        }
    }
    
    /**
     * <p>
     * deletes the student details from the database by passing the id of the student
     * </p>
     */
    public void deleteStudentById(int id) throws DatabaseException {
        try {
            Session session = getSession(); 
            Student student = (Student) session.get(Student.class, id);
            session.delete(student);
        } catch (IllegalArgumentException e) {                       
            throw new DatabaseException("Entered student is not deleted. Kindly try again with vaild student id", e);
        }                            
    }
    
    /**
     * <p>
     * adds the student details in the database
     * </p>
     */
    public void insertStudent(Student student) throws DatabaseException {
        Session session = getSession();
        try {
            session.save(student);            
        } catch (HibernateException e) {
        	e.printStackTrace();
        	throw new DatabaseException("Entered student is not added. Student ID already exits..", e);
        }                                                                         
    }

    /**
     * <p>
     * Retrieves the list of students from the database
     * </p>
     */
    public List<Student> retrieveStudents() throws DatabaseException {
        Session session = getSession();        
        try {
            List<Student> students = session.createQuery("FROM Student").list();
            if (students.isEmpty()) {
                throw new DatabaseException("The student list is empty");
            }            
            return students;              
        } catch (HibernateException e) {            
            throw new DatabaseException("The students are not viewed. Kindly try again with vaild input data", e);
        }                      
    }
    
    /**
     * <p>
     * Edits the student details and updates the database
     * </p>
     */
    public void editStudent(Student student) throws DatabaseException {
	Session session = getSession();
        try {
            session.update(student);
        } catch (HibernateException e) {
            throw new DatabaseException("Please check the data you have given..." , e);  
       }
    }
}