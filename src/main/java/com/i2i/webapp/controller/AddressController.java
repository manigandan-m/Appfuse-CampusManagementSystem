package com.i2i.webapp.controller;

import java.util.List;

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
import com.i2i.service.AddressManager;
import com.i2i.service.RoleManager;
import com.i2i.service.StandardService;
import com.i2i.service.UserManager;
import com.i2i.model.Address;
import com.i2i.model.Role;
import com.i2i.model.Student;
import com.i2i.model.Teacher;
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
public class AddressController  {
    private AddressManager addressManager = null;
    private UserManager userManager = null;
    private RoleManager roleManager = null;
    private StandardService standardService = null;

    @Autowired
    public void setAddressManager(AddressManager addressManager) {
        this.addressManager = addressManager;
    }
    
    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
    @Autowired
    public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }
    
    @Autowired
    public void setStandardService(StandardService standardService) {
        this.standardService = standardService;
    }

    /**
     * <p>
     * The method gets the address details from the JSP page and passes it
     * It gets the user by passing the id of user in the UserService class method.
     * The id of the user is passed from the JSP Page. Depending on the role of the user, the user is redirected to the next JSP Page
     * </p>
     * 
     * @param address
     *     the particulars of the place where a person lives is situated
     * @return
     *     if the role of the user is teacher it returns the JSP Page where user can enter teacher details
     *     if the role of the user is student it returns the JSP Page where user can enter student details
     */
    
    @RequestMapping(value ="/addAddress", method=RequestMethod.POST)
    public String addAddress(@ModelAttribute("Address") Address address, ModelMap map, BindingResult result) {         
        try {          
            Long userId = address.getUser().getId();
            System.out.println("In address controller:"+userId);
            User user = userManager.getUserById(userId);
            address.setUser(user);
            addressManager.addAddress(address);
            map.addAttribute("userId", userId);
            List<Role> roles = roleManager.getRoles();
            if((user.getRole().getName()).equals("ROLE_STUDENT")) {
                map.addAttribute("Student", new Student());
                map.addAttribute("standards", standardService.getStandards());
                return "AddStudent";
            } else if (user.getRole().getName().equals("ROLE_TEACHER")){
                map.addAttribute("Teacher", new Teacher());
                return "AddTeacher";
            } else {
                map.addAttribute("message", "Admin is created successfully");      
            }
        } catch (DatabaseException ex) {
        	ex.printStackTrace();
            map.addAttribute("message", ex.getMessage().toString());  
        }
        return "Address";
    }
    
    /**
     * It displays all the addresses by invoking the AddressService class method.
     * It sends the list of the address to the JSP Page by using ModelAndView object
     *  
     * @return
     *     returns the JSP Page where all the addresses are displayed
     */
    @RequestMapping(value = "/displayAddresses", method=RequestMethod.GET) 
    public ModelAndView displayStudents() {
        try {                                                                         
            return new ModelAndView("DisplayAddresses","addresses", addressManager.getAddresses());             
        } catch (DatabaseException e) {
            return new ModelAndView("DisplayAddresses","displayMessage", e.getMessage());                          
        } 
    }
    
    /**
     * It provides the page where the user can edit the address details. It calls the AddressService method 
     * to get the address object and passes it to the JSP Page
     *  
     * @param id
     *     id of address whose details has to be edited
     * @return 
     *     returns the JSP Page where user can edit the address details
     * @throws ServletException
     *     when a servlet related problem occurs.
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     */
    @RequestMapping(value = "/editAddressById", method = RequestMethod.GET)
    public String editAddressForm(@RequestParam("addressId") int id, ModelMap model) {
         try {
             model.addAttribute("Address", addressManager.getAddressById(id));
             return "EditAddress";
         } catch (DatabaseException e) {
             model.addAttribute("Message", e.getMessage().toString());
             return "EditAddress";
         }
    }
    
    /**
     * <p>
     * Edits the address details by sending the address model object details to the assigned JSP page.
     * Invokes the AddressService method to update the changes.
     * </p>
     * 
     * @param address
     *     the particulars of the place where a person lives is situated     
     * @param message
     *     Status message if the given operation was successful or failure
     * @return EditAddress
     *     JSP Page for editing address details
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     * @throws ServletException
     *     when a servlet related problem occurs.
     */
    @RequestMapping(value = "/editAddress", method = RequestMethod.POST)
    public String editAddress(@ModelAttribute("Address") Address address, BindingResult result, ModelMap message) {  
        try {
        	User user = userManager.getUserById(address.getUser().getId());
            address.setUser(user);
        	addressManager.editAddress(address);      
            message.addAttribute("Message", "Address Edited Successfully");
            return "EditAddress";
        } catch (DatabaseException e) {
            message.addAttribute("Message", (e.getMessage().toString()));
            return "EditAddress";
        }
    }

}