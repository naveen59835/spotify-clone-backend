package com.niit.userproductservice.service;

import com.niit.userproductservice.model.User;

import java.util.List;

public interface UserTrackService {
    User saveUser(User user);

    boolean deleteUser(String email);
    List<User> getTrackList();
    List<User> getTracksByCustomer(String trackName);
    public User updateMusic (User user, String email);

}
