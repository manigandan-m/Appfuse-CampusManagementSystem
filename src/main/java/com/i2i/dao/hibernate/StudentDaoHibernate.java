package com.i2i.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;
import org.hibernate.HibernateException;

//import com.i2i.model.Standard;
import com.i2i.model.Student;
import com.i2i.model.User;
import com.i2i.exception.DatabaseException;
import com.i2i.dao.StudentDao;
import com.i2i.dao.UserDao;

/**
 * <p>
 * DataAccessObject(Dao) which is used to perform create, retrieve, retrieve all, delete operations for model Student
 * It allocates user model object to the student model object by assigning the id of user to the particular student
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Zeeshan
 * 
 * @created 2016-09-07
 */
@Repository("studentDao")
@Transactional
public class StudentDaoHibernate extends GenericDaoHibernate<Student, Long> implements StudentDao {         
    
	/**
     * Constructor that sets the entity to User.class.
     */
    public StudentDaoHibernate() {
        super(Student.class);
    }
    
    /**
     * Saves the student model object to the database by passing it
     * 
     * @param student
     *     a person who studies in a standard
     * @throws DatabaseException
     *     if there is an error in saving the student like HibernateException
     *     
     */
    /*public void insertStudent(Student student, User user, Standard standard) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {  
            student.setStandard(standard);
            student.setUser(user);
            session.save(student);            
            transaction.commit(); 
        } catch (HibernateException e) {   
            throw new DatabaseException("Entered student is not added. Student ID already exits..", e);
        } finally {
            session.close();
        }                                                                         
    }*/  
    public void insertStudent(Student student) throws DatabaseException {
        Session session = getSession();
        
        try {            
            session.save(student);            
        } catch (HibernateException e) {   
            throw new DatabaseException("Entered student is not added. Student ID already exits..", e);
        }                                                                        
    }  
    
    /**
     * Retrieves the student object by passing id of the student
     * 
     * @param id
     *     id of the student whose record has to be viewed
     * @return student
     *    student entity which contains the details of the student
     * @throws DatabaseException
     *     if there is an error in getting the student like HibernateException
     */
    public Student findStudentById(int id) throws DatabaseException {        
        Session session = getSession();        
        try {                           
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
     * Deletes the student model object by passing studentId 
     * 
     * @param studentId
     *     id of the student to delete
     * @throws DatabaseException
     *     if there is an error in deleting the student like HibernateException
     */
    public void deleteStudentById(int id) throws DatabaseException {
        Session session = getSession();
        
        try {
            Student student = (Student) session.get(Student.class, id); 
            session.delete(student);          
        } catch (IllegalArgumentException e) {                       
            throw new DatabaseException("Entered student is not deleted. Kindly try again with vaild student id", e);
        }                          
    }
    
    /**
     * Edits the student details by accessing the database, passing the Student.
     * 
     * @param student
     *     student whose details need to be edited
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public void editStudent(Student student) throws DatabaseException {
	Session session = getSession();
        
        try {
            session.update(student);                                                                   
        } catch (HibernateException e) {
            throw new DatabaseException("Please check the data you have given..." , e);  
       }
    }
    
    /**
     * Retrieves  the list of students from the database
     * 
     * @return students
     *     ArrayList of students
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public List<Student> retrieveStudents() throws DatabaseException {
        List<Student> students = null;
        try {
            students = getSession().createQuery("FROM Student").list();
            for(Student student : students) {
            	System.out.println(student.getFatherFirstName());
            }
            if (students.isEmpty()) {
                throw new DatabaseException("The student list is empty");
            }            
            return students;              
        } catch (HibernateException e) {            
            throw new DatabaseException("The students are not viewed. Kindly try again with vaild input data", e);
        }                     
    }   
}