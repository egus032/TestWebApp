
package com.mycompany.testwebapp.controllers;



import com.mycompany.testwebapp.dao.UserService;
import com.mycompany.testwebapp.users.User;
import com.mycompany.testwebapp.users.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author eguseynov
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void listUsers(){
        new Users(userService.findAll());
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User findUserById(@PathVariable Integer id){
        return userService.findById(id);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@RequestBody User user){
        logger.info("Create user " + user);
        userService.save(user);
        logger.info("User created successfully " + user);
        return user;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody User user, @PathVariable Integer id){
        logger.info("Update user " + user);
        userService.save(user);
        logger.info("User created successfully " + user);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@RequestBody Integer id){
        logger.info("Delete user by id " + id);
        User user = userService.findById(id);
        userService.delete(user);
        logger.info("User deleted successfully");
    }
    
        
    
    
}
