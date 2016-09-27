package com.i2i.webapp.controller;

import com.i2i.Constants;
import com.i2i.dao.SearchException;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Address;
import com.i2i.model.User;
import com.i2i.service.RoleManager;
import com.i2i.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Simple class to retrieve a list of users from the database.
 * <p/>
 * <p>
 * <a href="UserController.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Controller
public class UserController {
    private UserManager userManager = null;
    private RoleManager roleManager = null;

    @Autowired
    public void setUserService(UserManager userManager) {
        this.userManager = userManager;
    }
    
    @Autowired
    public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    @RequestMapping(value ="/admin/users*", method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query) throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(Constants.USER_LIST, userManager.search(query));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(userManager.getUsers());
        }
        return new ModelAndView("admin/userList", model.asMap());
    }
    
    /**
     * This returns a JSP Page where user can add it's details. It passes a User to the JSP Page
     * 
     * @return User
     *     JSP Page where user can add the user details
     */
    @RequestMapping(value = "/User", method=RequestMethod.GET) 
    public String addUser(ModelMap model) {
    	try { 
            model.addAttribute("User", new User());
            model.addAttribute("roleList", roleManager.getRoles());
    	} catch (DatabaseException ex) { 
            model.addAttribute("message", ex.getMessage().toString());                                    
        } 
        return "User";
    }
    
    /**
     * The method gets the user details from the JSP Page and invokes the 
     * UserService class method and sends the details as an object of model class User
     * 
     * @param user
     *     user is a person who can be an admin, teacher or a student. It contains all the user details that is sent from the JSP Page
     * @return
        map
     *     returns the JSP Page called Address
     */
    @RequestMapping(value = "/addUser", method=RequestMethod.POST)
    public String addUser(@ModelAttribute("User") User user, BindingResult result, ModelMap map) {      
    	System.out.println("In user controller:"+user.getId());
    	System.out.println("In user controller:"+user.getFirstName());
        map.addAttribute("Address", new Address());
        userManager.save(user);
        map.addAttribute("userId",user.getId());
        System.out.println("In user controller:"+user.getId());
        return "Address";       
    }    
    
    /**
     * User details of a user can be viewed by passing the username of the user as a parameter
     * 
     * @param username
     *     username of the user whose user details has to be viewed
     * @return
     *     returns the JSP Page where user details of a single user can be viewed 
     */
    /*@RequestMapping(value = "/searchUser", method=RequestMethod.GET)  
    public ModelAndView viewUser(@RequestParam("username") String username) {                
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("User");
        modelView.addObject("User", new User());
        try {       	
            modelView.addObject("searchUser", userManager.getUserByUsername(username));        	                                          
        } catch (UsernameNotFoundException e) {
            modelView.addObject("searchMessage", e.getMessage());             
        }
        return modelView; 
    }*/ 
    
    /**
     * User details of a user can be viewed by passing the id of the user as a parameter
     * 
     * @param userId
     *     id of the user whose user details has to be viewed
     * @return
     *     returns the JSP Page where user details of a single user can be viewed 
     */
    /*@RequestMapping(value = "/searchUserById", method=RequestMethod.GET)  
    public ModelAndView viewUserById(@RequestParam("userId") Long userId) {                
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("User");
        modelView.addObject("User", new User());
        try {       	
            modelView.addObject("searchUser", userManager.getUserById(userId));        	                                          
        } catch (DatabaseException e) {
            modelView.addObject("searchMessage", e.getMessage());             
        }
        return modelView; 
    }*/ 
    
    /**
     * Edits the details of the user using it's id
     * 
     * @param id
     *     id of user entered by the user
     * @return EditUser
     *     JSP Page where user can make changes to the various attributes of the user
     * 
     */
    /*@RequestMapping(value = "/editUserById", method = RequestMethod.GET)
    public String editUserForm(@RequestParam("userId") Long id, ModelMap model) {
    	try {
    	    model.addAttribute("User", userManager.getUserById(id));
            model.addAttribute("roleList", roleManager.getRoles());
            return "EditUser";
    	} catch (DatabaseException e) {
    	    model.addAttribute("Message", e.getMessage().toString());
            return "EditUser";
    	}
    }*/
    
    /**
     * <p>
     * Edits the user details by sending the user to the assigned JSP page.
     * Invokes the UserService method to update the changes.
     * </p>
     * 
     * @param user
     *     user is a person who can be an admin, teacher or a student. It contains all the user details that is sent from the JSP Page
     * @param message
     *     Status message
     * @return EditUser
     *     JSP Page for editing user details
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     * @throws ServletException
     *     when a servlet related problem occurs.
     */
    /*@RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("User") User user, ModelMap message){  
        try {
        	message.addAttribute("roleList", roleManager.getRoles());
            userManager.editUser(user);      
            message.addAttribute("Message", "User Edited Successfully");
            return "EditUser";
    	} catch (DatabaseException e) {
    	    message.addAttribute("Message", (e.getMessage().toString()));
    	    return "EditUser";
    	}
    }*/
    
    /**
     * It invokes the UserService method to get all the users in the User class.
     * 
     * @return
     *     returns the list of users and sends to the JSP Page where they can be viewed
     */
    /*@RequestMapping(value = "/displayUsers", method=RequestMethod.GET) 
    public ModelAndView displayUsers() {
    	                                                                        
            return new ModelAndView("DisplayUsers","users", userManager.getUsers());                                           
        
    }*/
}
