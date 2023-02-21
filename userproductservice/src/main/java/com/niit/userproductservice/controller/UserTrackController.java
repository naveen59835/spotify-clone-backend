/*
 * Author : Naveen Kumar
 * Date : 12-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userproductservice.controller;

import com.niit.userproductservice.model.User;
import com.niit.userproductservice.service.UserTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v2")

public class UserTrackController {
    ResponseEntity responseEntity;
    UserTrackService userTrackService;
    @Autowired

    public UserTrackController(UserTrackService userTrackService) {

        this.userTrackService = userTrackService;
    }
    @GetMapping("/demo")
    public ResponseEntity <String> get() {
        return new ResponseEntity<String>("Sample", HttpStatus.OK);
    }
    @PostMapping("/track")
    public ResponseEntity<?> saveTracks(@RequestBody User user) {
        try {
            User user1= userTrackService.saveUser(user);
            return new ResponseEntity<User>(user1, HttpStatus.OK);

        }
        catch (Exception e) {
            System.out.println("exception arised");
            return new ResponseEntity<String>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/track/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable ("email") String email){
        try {
            userTrackService.deleteUser(email);
            responseEntity=new ResponseEntity<String>("Successfully Deleted",HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @GetMapping("/tracks")

    public ResponseEntity<?> getAllTracks() {
        try{
            responseEntity=new ResponseEntity(userTrackService.getTrackList(),HttpStatus.OK);
        }
        catch (Exception e) {
            responseEntity=new ResponseEntity (e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @GetMapping("/tracks/{trackName}")
    public ResponseEntity<?> getproductsByCustomer(@PathVariable String trackName){
        try {
            responseEntity=new ResponseEntity(userTrackService.getTracksByCustomer(trackName),HttpStatus.OK);
        }

        catch (Exception e) {
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @PutMapping("/musictrack/{email}")
    public ResponseEntity<?> updateMusic(@RequestBody User user , @PathVariable String email){
        User updateMusic = userTrackService.updateMusic(user,email);
        if(updateMusic != null){
            return new ResponseEntity<User>(updateMusic,HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Error Occured",HttpStatus.FAILED_DEPENDENCY);
        }
    }


}
