package com.poly.recruiterproject.service;

import com.poly.recruiterproject.entity.UsersType;
import com.poly.recruiterproject.repository.UserTypeRepositoty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeService {
    private final UserTypeRepositoty userTypeRepositoty;

    public UsersTypeService(UserTypeRepositoty userTypeRepositoty) {
        this.userTypeRepositoty = userTypeRepositoty;
    }

    public List<UsersType> getAllUsersTypes() {
        return userTypeRepositoty.findAll();
    }

}
