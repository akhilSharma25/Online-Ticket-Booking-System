package com.learning.service;

import com.learning.model.User;
import com.learning.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepo repo;


    @Override
    public Integer addUser(User user) {
        com.learning.model.User user1 = repo.save(user);
        return  user1.getUserId();
    }
}
