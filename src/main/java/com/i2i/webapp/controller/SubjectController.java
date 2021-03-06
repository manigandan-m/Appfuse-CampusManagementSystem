package com.i2i.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DatabaseException;
import com.i2i.service.StandardService;
import com.i2i.service.SubjectService;
import com.i2i.service.TeacherService;
import com.i2i.model.Subject;

/**
 * Controller to perform add, update, delete, retrieve, retrieve all operations using Subject by invoking SubjectService class methods.
 * It is used to set views (JSP Pages) for the methods.
 * Assigns handlers (methods) to process the requests
 *   
 * @author Manigandan
 * 
 * @created 2016-09-08
 * 
 */
@Controller
public class SubjectController {
    private SubjectService subjectService;
    private TeacherService teacherService;
    private StandardService standardService;
    
    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    
    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    
    @Autowired
    public void setStandardService(StandardService standardService) {
        this.standardService = standardService;
    }
    
    /**
     * <p>
     * It is used to send the subject and the lists of the standards and teachers to a JSP Page where
     * user can add the details of the subject
     * </p>
     *   
     * @param model
     *     used to send the subject model object and the lists of standards and teachers
     * @return
     *     JSP Page where user can add the subject details
     */
    @RequestMapping(value = "/Subject", method=RequestMethod.GET) 
    public String Subjects(ModelMap model) {
        try { 
            model.addAttribute("subjects", subjectService.getSubjects());
    	}  catch (DatabaseException ex) {            
            model.addAttribute("message", ex.getMessage().toString()); 
        }     
        return "RetrieveSubjects";
    }       
    
    /**
     * <p>
     * The method gets the subject details from the JSP Page and invokes the 
     * SubjectService class method and sends the details as Subject
     * </p>
     * 
     * @param subject
     *     a branch of knowledge studied or taught in a school
     * @return
     *     returns the JSP Page called SubjectInformation
     */
    @RequestMapping(value = "/addSubject", method=RequestMethod.POST) 
    public ModelAndView addSubject(@ModelAttribute("Subject") Subject subject) {
        String message = null;    
        try {                                                     
            subjectService.addSubject(subject);                                        
            message = "Subject is added successfully";            
        }  catch (DatabaseException ex) {            
            message = ex.getMessage().toString(); 
        } 
        return new ModelAndView("RetrieveSubjects","displayMessage", message);       
    }

    /**
     * <p>
     * Used to find the details of a subject by getting the subject code. It passes
     * subject to the JSP Page where the subject details can be viewed
     * </p>
     *   
     * @param subjectCode
     *     code of the subject
     * @return
     *     JSP Page where subject details can be viewed
     */
    @RequestMapping(value = "/searchSubject", method=RequestMethod.GET)  
    public ModelAndView viewSubject(@RequestParam("subjectCode") String subjectCode) {                
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("SubjectInformation");
        modelView.addObject("Subject", new Subject());
        try {           
            modelView.addObject("searchSubject", subjectService.getSubjectBySubjectCode(subjectCode));                  
        } catch (DatabaseException e) {
            modelView.addObject("searchMessage", e.getMessage());             
        }
        return modelView; 
    }

    /**
     * <p>
     * Deletes the subject record by passing the code of the subject
     * </p>
     * 
     * @param subjectCode
     *     code of the subject whose record has to be deleted
     * @return
     *     JSP Page where the user is redirected
     */
    @RequestMapping(value = "/deleteSubject", method=RequestMethod.GET) 
    public ModelAndView deleteStudent(@RequestParam("subjectCode") String subjectCode) {        
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("SubjectInformation");
        modelView.addObject("Subject", new Subject());          
        try {                                                           
            subjectService.removeSubjectBySubjectCode(subjectCode);
            modelView.addObject("deleteMessage", "Student Id " + subjectCode + " is deleted");                                   
        } catch (DatabaseException e) {
            modelView.addObject("deleteMessage", e.getMessage());                                    
        } 
        return modelView;         
    }
    
    /**
     * <p>
     * This method is used to assign a teacher to a subject. It is done by passing the id of subject
     * It also sends the list of teachers by invoking the TeacherService method and also the Subject
     * </p>
     *  
     * @param subjectId
     *     code of the subject
     * @return
     */
    @RequestMapping(value = "/assignTeacher", method=RequestMethod.GET) 
    public ModelAndView assignTeacherToSubjectForm(@RequestParam("subjectId") String subjectId) {        
        ModelAndView modelView = new ModelAndView();              
        modelView.setViewName("AllocateTeacher"); 
        try {  
            modelView.addObject("teachers", teacherService.getTeachers());
            modelView.addObject("Subject", subjectService.getSubjectBySubjectCode(subjectId));                                  
        } catch (DatabaseException e) {            
            modelView.addObject("message", e.getMessage());             
        }
        return modelView;         
    }    
    
    /**
     * <p>
     * Allots the teacher to the subject by invoking the SubjectService class method and passing the Subject 
     * </p>
     * 
     * @param subject
     *     object of class Subject
     * @return
     */
    @RequestMapping(value = "/allocateTeacher", method=RequestMethod.POST) 
    public ModelAndView assignTeacherToSubject(@ModelAttribute("Subject") Subject subject) {        
        ModelAndView modelView = new ModelAndView();              
        modelView.setViewName("AllocateTeacher"); 
        try {  
            subjectService.allotTeacher(subject);                                                    
        } catch (DatabaseException e) {            
            modelView.addObject("message", e.getMessage());             
        }                                             
        return modelView;         
    }  
}
