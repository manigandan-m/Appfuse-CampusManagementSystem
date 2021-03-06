package com.i2i.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DatabaseException;
import com.i2i.service.StandardService;
import com.i2i.service.StudentService;
import com.i2i.service.UserManager;
import com.i2i.model.Student;
import com.i2i.model.User;

/**
 * Controller to perform add, update, delete, retrieve, retrieve all operations using Student
 * by invoking StudentService class methods.
 * It is used to set views (JSP Pages) for the methods.
 * Assigns handlers (methods) to process the requests
 *   
 * @author Zeeshan Ali
 * 
 * @created 2016-09-07
 * 
 */
@Controller
public class StudentController  {
    private StudentService studentService = null;
    private UserManager userManager = null;
    private StandardService standardService = null;

    @Autowired
    public void setStudentManager(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
    @Autowired
    public void setStandardService(StandardService standardService) {
        this.standardService = standardService;
    }

    /**
     * <p>
     * Gets the student details from the JSP Page and passes it as student.
     * It gets the userId and invokes the UserService method to get the corresponding user.
     * It invokes the StudentService method and sends the user and student for adding student details
     * </p>
     *  
     * @param student
     *     person who is a pupil of a school   
     * @return
     */
    @RequestMapping(value = "/addStudent", method=RequestMethod.GET) 
    public ModelAndView addStudent(@ModelAttribute("Student") Student student, BindingResult result) {
        String message = null;    
        try {
            System.out.println("In student controller:"+ student.getUser().getId());
            User user = userManager.getUserById(student.getUser().getId());
            student.setUser(user);
            studentService.addStudent(student);                                        
            message = "Student is added successfully";            
        } catch (DatabaseException ex) {
            ex.printStackTrace();
            message = ex.getMessage().toString();                         
        } 
        return new ModelAndView("AddStudent","addMessage", message);       
    }

    /**
     * <p>
     * Used to view the record of the student by passing roll number
     * It invokes the StudemtService class method and gets the Student and passes it to JSP Page
     * </p>
     * 
     * @param studentId
     *     roll number of the student
     * @return
     *     JSP Page where the student details can be viewed
     */
    @RequestMapping(value = "/viewStudent", method=RequestMethod.GET) 
    public ModelAndView viewStudent(@RequestParam("rollNumber") int studentId) {               
        ModelAndView modelView = new ModelAndView();  
        modelView.setViewName("SearchStudent");
        try {          
            modelView.addObject("searchStudent", studentService.getStudentById(studentId));                 
        } catch (DatabaseException e) {
            modelView.addObject("searchMessage", e.getMessage());            
        }
        return modelView;
    }
    
    /**
     * <p>
     * Used to view the record of the student by passing roll number
     * It invokes the StudemtService class method and gets the Student and passes it to JSP Page
     * </p>
     * 
     * @param studentId
     *     roll number of the student
     * @return
     *     JSP Page where the student details can be viewed
     */
    @RequestMapping(value = "/displayStudent", method=RequestMethod.GET) 
    public ModelAndView displayStudent(@RequestParam("rollNumber") int studentId) {               
        ModelAndView modelView = new ModelAndView();  
        modelView.setViewName("DisplayStudent");
        try {          
            modelView.addObject("searchStudent", studentService.getStudentById(studentId));                                  
        } catch (DatabaseException e) {
            modelView.addObject("searchMessage", e.getMessage());            
        }
        return modelView;
    }

    /**
     * <p>
     * It displays all the students by invoking the StudentService class method.
     * It sends the list of the students to the JSP Page
     * </p>
     *  
     * @return
     *     returns the JSP Page where all the students are displayed
     */
    @RequestMapping(value = "/displayStudents", method=RequestMethod.GET) 
    public ModelAndView displayStudents() {
    	try {                                                                         
            return new ModelAndView("RetrieveStudents","students", studentService.getStudents());                                           
        } catch (DatabaseException e) {
            return new ModelAndView("RetrieveStudents","displayMessage", e.getMessage());                                
        } 
    }

    /**
     * <p>
     * Deletes the standard record by passing the roll number of the standard
     * </p>
     * 
     * @param standardId
     *     roll number of the standard whose record has to be deleted
     * @return
     *     JSP Page where the user is redirected
     */
    @RequestMapping(value = "/deleteStudent", method=RequestMethod.GET)
    public ModelAndView deleteStudent(@RequestParam("rollNumber") int studentId) {       
        ModelAndView modelView = new ModelAndView();
        try {                                                          
        	studentService.removeStudentById(studentId);
        } catch (DatabaseException e) {
            modelView.addObject("deleteMessage", e.getMessage());                                   
        }
        return displayStudents();        
    }
    
    /**
     * <p>
     * Gets the roll number of the student whose details needs to be edited
     * </p>
     * 
     * @param studentId
     *     rollNumber of student
     * @param map
     *     sends the object of Student class whose record has to be edited
     * 
     * @return
     */
    @RequestMapping(value="/editStudentDetails", method=RequestMethod.GET)
    public String editTeacherDetails(@RequestParam("rollNumber") int studentId, ModelMap map) {
    	try {
    	    Student student = studentService.getStudentById(studentId);    	    
    	    map.addAttribute("student",student);
    	} catch (DatabaseException e) {
    	    map.addAttribute("Message",e.getMessage().toString());
    	}
    	return "EditStudentDetails";
    }
    
    /**
     * <p>
     * Edits the details of the student using it's id
     * </p>
     * 
     * @param id
     *     id of student entered by the user
     * @return EditStudent
     *     JSP Page where user can make changes to the various attributes of the student
     * @throws ServletException
     *     when a servlet related problem occurs.
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     */
    @RequestMapping(value = "/editStudentById", method = RequestMethod.GET)
    public String editStudentForm(@RequestParam("rollNumber") int rollNumber, ModelMap model) {
    	try {
    	    model.addAttribute("standards", standardService.getStandards());
    	    model.addAttribute("Student", studentService.getStudentById(rollNumber));
    	    return "EditStudent";
    	} catch (DatabaseException e) {
    	    model.addAttribute("Message", e.getMessage().toString());
    	    return "EditStudent";
    	}
    }
    
    /**
     * <p>
     * Edits the student details by sending the student model object details to the assigned JSP page.
     * Invokes the StudentService method to update the changes.
     * </p>
     * 
     * @param student
     *     person who is a pupil of a school    
     * @param message
     *     Status message
     * @return EditStudent
     *     JSP Page for editing student details
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     * @throws ServletException
     *     when a servlet related problem occurs.
     */
    @RequestMapping(value = "/editStudent", method = RequestMethod.POST)
    public String editStudent(@ModelAttribute("Student") Student student, BindingResult result, ModelMap message) {  
        try {
            User user = userManager.getUserById(student.getUser().getId());
            student.setUser(user);
            studentService.editStudent(student);      
            message.addAttribute("Message", "Student Edited Successfully");
            return "EditStudent";
    	} catch (DatabaseException e) {
    	    message.addAttribute("Message", (e.getMessage().toString()));
    	    return "EditStudent";
    	}
    }
}
