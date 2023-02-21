/*
 * Author : Naveen Kumar
 * Date : 11-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userauthservice.service;

import com.niit.userauthservice.model.User;
import com.niit.userauthservice.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User checkAuth(User user) {
        Optional<User> optionalUser = userRepo.findById(user.getUserId());
            if (optionalUser.isPresent()) {
                User user1 = optionalUser.get();
                if (user1.getPassword().equals(user.getPassword())) {
                    return user1;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }

    @Override
    public User loginAuth(String userId) {
        return userRepo.findById(userId).orElse(null);
    }
}

