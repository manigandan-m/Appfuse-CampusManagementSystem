package com.i2i.webapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;

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
import com.i2i.service.TeacherService;
import com.i2i.service.UserManager;
import com.i2i.model.Teacher;
import com.i2i.model.User;

@Controller
public class TeacherController  {
    private TeacherService teacherService = null;
    private UserManager userManager = null;

    @Autowired
    public void setTeacherManager(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    
    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    /**
     * <p>
     * Gets the teacher details from the JSP Page and passes it as a Teacher.
     * It gets the userId and invokes the UserService method to get the corresponding user object.
     * It invokes the TeacherService method and sends the user and teacher object for adding teacher details
     * </p>
     *  
     * @param teacher
     *     a person who teaches in a school.
     * @return
     */
    @RequestMapping(value = "/addTeacher", method=RequestMethod.POST)
    public ModelAndView addTeacher(@ModelAttribute("Teacher") Teacher teacher, BindingResult result) {
        String message = null;    
        try {      
            User user = userManager.getUserById(teacher.getUser().getId());
            teacher.setUser(user);
        	teacherService.addTeacher(teacher);                                       
            message = "Teacher is added successfully";            
        } catch (DatabaseException ex) {            
            message = ex.getMessage().toString();                         
        }
        return new ModelAndView("AddTeacher","addMessage", message);       
    }

    
    /**
     * <p>
     * Used to view the record of the teacher by passing roll number
     * It invokes the StudemtService class method and gets the object of Teacher class and passes it to JSP Page
     * </p>
     * 
     * @param teacherId
     *     ID of the teacher
     * @return
     *     JSP Page where the teacher details can be viewed
     */
    @RequestMapping(value = "/viewTeacher", method=RequestMethod.GET) 
    public ModelAndView viewTeacher(@RequestParam("teacherId") int teacherId) {               
        ModelAndView modelView = new ModelAndView();  
        modelView.setViewName("SearchTeacher");
        try {
            modelView.addObject("searchTeacher", teacherService.getTeacherById(teacherId));
        } catch (DatabaseException e) {
            modelView.addObject("searchMessage", e.getMessage());            
        }
        return modelView;
    }
    
    /**
     * <p>
     * Used to view the record of the teacher by passing roll number
     * It invokes the StudemtService class method and gets the Teacher and passes it to JSP Page
     * </p>
     * 
     * @param teacherId
     *     ID of the teacher
     * @return
     *     JSP Page where the teacher details can be viewed
     */
    @RequestMapping(value = "/displayTeacher", method=RequestMethod.GET) 
    public ModelAndView displayTeacher(@RequestParam("teacherId") int teacherId) {               
        ModelAndView modelView = new ModelAndView();  
        modelView.setViewName("DisplayTeacher");
        try {
            modelView.addObject("searchTeacher", teacherService.getTeacherById(teacherId));     
        } catch (DatabaseException e) {
            modelView.addObject("searchMessage", e.getMessage());            
        }
        return modelView;
    }
    
    /**
     * <p>
     * It displays all the teachers by invoking the TeacherService class method.
     * It sends the list of the teachers to the JSP Page by using ModelAndView object
     * </p>
     *  
     * @return
     *     returns the JSP Page where all the teachers are displayed
     */
    @RequestMapping(value = "/displayTeachers", method=RequestMethod.GET) 
    public ModelAndView displayTeachers() {
    	try {                                                                         
            return new ModelAndView("RetrieveTeachers","teachers", teacherService.getTeachers());                                           
        } catch (DatabaseException e) {
            return new ModelAndView("RetrieveTeachers","displayMessage", e.getMessage());              
        } 
    }
    
    /**
     * <p>
     * Deletes the teacher record by passing the ID of the teacher
     * </p>
     * 
     * @param teacherId
     *     ID of the teacher whose record has to be deleted
     * @return
     *     JSP Page where the user is redirected
     */
    @RequestMapping(value = "/deleteTeacher", method=RequestMethod.GET) 
    public ModelAndView deleteTeacher(@RequestParam("teacherId") int teacherId) {       
        ModelAndView modelView = new ModelAndView();
        try {                                                          
            teacherService.removeTeacherById(teacherId);
        } catch (DatabaseException e) {
            modelView.addObject("deleteMessage", e.getMessage());                                   
        }
        return displayTeachers();        
    }
    
    /**
     * <p>
     * Gets the teacherId of the teacher whose details needs to be edited
     * </p>
     * 
     * @param teacherId
     *     id of teacher
     */
    @RequestMapping(value="/editTeacherDetails", method=RequestMethod.GET)
    public String editTeacherDetails(@RequestParam("teacherId") int teacherId, ModelMap map) {
    	try {
    	    Teacher teacher = teacherService.getTeacherById(teacherId);
    	    map.addAttribute("teacher",teacher);
    	} catch(DatabaseException e) {
    	    map.addAttribute("Message",e.getMessage().toString());
    	}
    	return "EditTeacherDetails";
    }
    
    /**
     * <p>
     * Edits the details of the teacher using it's id
     * </p>
     * 
     * @param id
     *     id of teacher entered by the user
     * @return EditTeacher
     *     JSP Page where user can make changes to the various attributes of the teacher
     * @throws ServletException
     *     when a servlet related problem occurs.
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     */
    @RequestMapping(value = "/editTeacherById", method = RequestMethod.GET)
    public String editTeacherForm(@RequestParam("teacherId") String id, ModelMap model) throws ServletException, IOException {
    	 try {
    	     model.addAttribute("Teacher", teacherService.getTeacherById(Integer.parseInt(id)));
             return "EditTeacher";
    	 } catch (DatabaseException e) {
    	     model.addAttribute("Message", e.getMessage().toString());
    	     return "EditTeacher";
    	 }
    }
    
    /**
     * <p>
     * Edits the teacher details by sending the teacher details to the assigned JSP page.
     * Invokes the TeacherService method to update the changes.
     * </p>
     * 
     * @param teacher
     *     Object of Teacher class    
     * @param message
     *     Status message, if the operation was successful or failure
     * @return EditTeacher
     *     JSP Page for editing teacher details
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     * @throws ServletException
     *     when a servlet related problem occurs.
     */
    @RequestMapping(value = "/editTeacher", method = RequestMethod.POST)
    public String editTeacher(@ModelAttribute("Teacher") Teacher teacher, BindingResult result, ModelMap message) {  
        try {
            User user = userManager.getUserById(teacher.getUser().getId());
            teacher.setUser(user);
            teacherService.editTeacher(teacher);      
            message.addAttribute("Message", "Teacher Edited Successfully");
            return "EditTeacher";
    	} catch (DatabaseException e) {
    	    message.addAttribute("Message", (e.getMessage().toString()));
    	    return "EditTeacher";
    	}
    }
}
