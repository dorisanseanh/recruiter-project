package com.poly.recruiterproject.service;

import com.poly.recruiterproject.entity.Users;
import com.poly.recruiterproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository, UsersRepository usersRepository1) {
        this.usersRepository = usersRepository1;
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }
    public Users addNew(Users user) {
        user.setActive(true);
        user.setRegistattionDate(new Date(System.currentTimeMillis()));
        return usersRepository.save(user);
    }
    public Optional<Users> getUserByUEmail(String email) {
        return usersRepository.findByEmail(email);

    }
}
