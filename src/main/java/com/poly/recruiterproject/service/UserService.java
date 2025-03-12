package com.poly.recruiterproject.service;

import com.poly.recruiterproject.entity.Users;
import com.poly.recruiterproject.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository, UsersRepository usersRepository1) {
        this.usersRepository = usersRepository1;
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }
}
