/*
 * Author : Naveen Kumar
 * Date : 12-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userproductservice.service;

import com.niit.userproductservice.model.User;
import com.niit.userproductservice.proxy.UserTrackProxy;
import com.niit.userproductservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.util.List;
@Service
public class UserTrackServiceImpl implements UserTrackService{
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserTrackProxy userTrackProxy;

    public UserTrackServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User saveUser(User user) {
       User user12=userRepo.save(user);
       if(!user12.getUserId().isEmpty())
       {
           ResponseEntity responseEntity=userTrackProxy.saveUserTrackInAuth(user12);
           System.out.println(responseEntity.getBody());

       }
       return user12;
    }

    @Override
    public boolean deleteUser(String email) {
        if(userRepo.findById(email).isPresent()){
            User user1=userRepo.findById(email).get();
            userRepo.delete(user1);
            return true;

        }
        return false;

    }

    @Override
    public List<User> getTrackList() {
        return userRepo.findAll();
    }

    @Override
    public List<User> getTracksByCustomer(String trackName) {
        return userRepo.findByCustomer(trackName);
    }

    @Override
    public User updateMusic(User user, String email) {
        if(userRepo.findById(email).isPresent()){
            User user1=userRepo.findById(email).get();
            if(user1.getName()!=null){
                user1.setName(user.getName());

            }
            if(user1.getPhoneNo()!=null){
                user1.setPhoneNo(user.getPhoneNo());
            }
            return userRepo.save(user1);
        }
        return null;

    }
}
