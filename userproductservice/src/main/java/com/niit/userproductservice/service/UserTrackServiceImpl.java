/*
 * Author : Naveen Kumar
 * Date : 12-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userproductservice.service;

import com.niit.userproductservice.model.User;
import com.niit.userproductservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.util.List;
@Service
public class UserTrackServiceImpl implements UserTrackService{
    UserRepo userRepo;

    public UserTrackServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
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
