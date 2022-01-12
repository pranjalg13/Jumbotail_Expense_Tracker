package com.jumbotail.expensetracker.Service;


import com.jumbotail.expensetracker.Entity.User;
import com.jumbotail.expensetracker.Repository.UserRepo;
import com.jumbotail.expensetracker.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User getUserById(String email){
        Optional<User> user = userRepo.findById(email);
        if (!user.isPresent())
            throw new EntityNotFoundException("User not found with id " + user.get().getEmail());
        return user.get();
    }

}
