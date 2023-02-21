package com.niit.userauthservice.service;

import com.niit.userauthservice.model.User;

public interface UserService {
    User save(User user) ;
    public User checkAuth(User user);
    public User loginAuth(String userId);

}
