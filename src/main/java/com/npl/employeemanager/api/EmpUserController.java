package com.npl.employeemanager.api;

import com.npl.employeemanager.model.EmpUser;
import com.npl.employeemanager.services.EmailService;
import com.npl.employeemanager.services.EmpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@CrossOrigin()
@RestController
public class EmpUserController {

    @Autowired
    @Qualifier("EmpUserService")
    private EmpUserService empUserService;

    @Autowired
    private EmailService emailService;

    @RequestMapping(
            value = "/api/users",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<EmpUser> createNewUser(@RequestBody EmpUser restEmpUser) throws IOException{
        EmpUser empUser=empUserService.createUser(restEmpUser);
        if(empUser.getId()!=null){

            try {
                empUser.setPassword(restEmpUser.getPassword());
                emailService.sendWelcomeEmail(empUser);
            }
            catch (MailSendException e){
                System.out.println("error sending welcome email = " + e.getMessage());
            }

        }
        return  new ResponseEntity<EmpUser>(empUser, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<EmpUser>> getAllUsers(){
        Collection<EmpUser> allUsers=empUserService.getAllUsers();
        return new ResponseEntity<Collection<EmpUser>>(allUsers,HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/users/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<EmpUser> findUserById(@PathVariable("id") Long id){
        EmpUser foundUser=empUserService.findOne(id);
        if(foundUser==null){
            return  new ResponseEntity<EmpUser>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EmpUser>(foundUser,HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/users",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<EmpUser>updateUser(@RequestBody EmpUser restEmpUser){
        if(restEmpUser.getId()==null){
            return new ResponseEntity<EmpUser>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        EmpUser updatedUser=empUserService.updateUser(restEmpUser);
        return new ResponseEntity<EmpUser>(updatedUser,HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/users/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<EmpUser>deleteUser(@PathVariable("id") Long id){
        empUserService.deleteUser(id);
        return new ResponseEntity<EmpUser>(HttpStatus.NO_CONTENT);
    }
}
