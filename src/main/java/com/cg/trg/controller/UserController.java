package com.cg.trg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.trg.entity.User;
import com.cg.trg.exception.BaseResponse;
import com.cg.trg.exception.UserException;
import com.cg.trg.service.UserService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

 

/**
 * 
 * @author Nikhil
 *
 */

 

@RestController
@RequestMapping("/api/users")

@Slf4j
public class UserController
{
    @Autowired(required = false)
    private UserService userService;

    /**
     * 
     * @param userName
     * @return
     */
    @ApiOperation(value = "Get user by User Name",response = User.class,
            tags="get-user-by-user-name",consumes="userName",httpMethod = "GET")
    @GetMapping("/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName)
    {
        try 
        {
            User user= userService.getUserByUserName(userName);
            log.info("User added"+ user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        catch(UserException userException) 
        {
            log.error(userException.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,userException.getMessage());
        }
    }

 
    /**
     * 
     * @return
     */
   
    @ApiOperation(value = "Get all user",response = User.class,
            tags="get-all-user",httpMethod = "GET")
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser()
    {
        try 
        {
            List<User> userList = userService.getAllUser();
            log.info("Returning all customer details");
            return new ResponseEntity<>(userList,HttpStatus.OK);
        }
        catch(UserException userException) 
        {
            log.error(userException.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,userException.getMessage());
        }
    }

 /**
  * 
  * @param user
  * @return
  */
    @ApiOperation(value = "Add User",
            consumes = "receives User object as request body",
            response =String.class)
    @PostMapping("/")
    public String addCustomer(@Valid @RequestBody User user) 
    {
        try 
        {
            Integer status= userService.addUser(user);
            if(status ==1)
            {
                log.info("user:"+user.getUserName()+" added to database");
                return "user:"+user.getUserName()+" added to database";
            }
            else 
            {
                log.debug("Unable to add user");
                return "Unable to add user to database";
            }
        }
        catch(UserException userException)
        {
            log.error(userException.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,userException.getMessage());
        }
    }
    
    /**
     * 
     * @param id
     * @return
     */
    @ApiOperation(value = "Delete User",
            consumes = "userId",
            response =String.class)
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) 
    {
        try
        {
            Integer status= userService.deleteUser(id);
            if(status ==1) 
            {
                log.info("user: "+id+" deleted from database");
                return "user: "+id+" deleted from database";
            }
            else
            {
                log.debug("Unable to delete user from database");
                return "Unable to delete user from database";
            }

 

        }
        catch(UserException UserException)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,UserException.getMessage());
        }
    }

    @PostMapping("/update/{newPassword}")
    @ApiOperation(value = "Update Password")
    public ResponseEntity<?> updatePassword( @RequestBody User user,@PathVariable String newPassword) {
        String str =userService.updatePassword(user, newPassword);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(1);
        baseResponse.setResponse(str);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    
   

   
}

