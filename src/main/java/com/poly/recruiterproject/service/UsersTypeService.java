package com.poly.recruiterproject.service;

import com.poly.recruiterproject.entity.UsersType;
import com.poly.recruiterproject.repository.UsersTypeRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeService {
    private final UsersTypeRepositoty userTypeRepositoty;

    @Autowired
    public UsersTypeService(UsersTypeRepositoty userTypeRepositoty) {
        this.userTypeRepositoty = userTypeRepositoty;
    }

    public List<UsersType> getAllUsersTypes() {
        return userTypeRepositoty.findAll();
    }

}
