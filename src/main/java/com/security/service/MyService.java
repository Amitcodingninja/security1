package com.security.service;

import com.security.UserDetailsImpl;
import com.security.dao.UserRepo;
import com.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyService implements UserDetailsManager {
    @Autowired
    private UserRepo userRepo;

    public void readData(String username) {


    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = userRepo.findByUsername(username);
        if (opt.isPresent()) {
            User user = opt.get();
            return new UserDetailsImpl();

        } else {
            // Exception Throw
            throw new UsernameNotFoundException("USER NOT FOUND");
        }

    }

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }
}
