/*
 * Author : Naveen Kumar
 * Date : 11-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userauthservice.Controller;

import com.niit.userauthservice.model.User;
import com.niit.userauthservice.service.SecurityTokenGenerator;
import com.niit.userauthservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1")


public class UserController {
    @Autowired
    SecurityTokenGenerator securityTokenGenerator;
    UserService userService;
    @Autowired

    public UserController(SecurityTokenGenerator securityTokenGenerator, UserService userService) {
        this.securityTokenGenerator = securityTokenGenerator;
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> registerUser (@RequestBody User user)  {
        User user1 = userService.save(user);
        if(user1 != null){
            return new ResponseEntity<User>(user1, HttpStatus.CREATED);

        }else {
            return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/checkauth")
    public ResponseEntity<?> checkAuth(@RequestBody User user){
        User user2=userService.checkAuth(user);
        if(user2!=null){
            return new ResponseEntity<>(securityTokenGenerator.generateToken(user2),HttpStatus.OK);

        }else {
            return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }



}
