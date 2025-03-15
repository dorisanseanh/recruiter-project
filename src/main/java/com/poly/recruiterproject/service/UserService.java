package com.poly.recruiterproject.service;

import com.poly.recruiterproject.entity.JobSeekerProfile;
import com.poly.recruiterproject.entity.RecruiterProfile;
import com.poly.recruiterproject.entity.Users;
import com.poly.recruiterproject.repository.JobSeekerProfileRepository;
import com.poly.recruiterproject.repository.RecruiterProfileRepository;
import com.poly.recruiterproject.repository.UsersRepository;
import com.poly.recruiterproject.repository.UsersTypeRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UsersRepository usersRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UsersRepository usersRepository, RecruiterProfileRepository recruiterProfileRepository, JobSeekerProfileRepository jobSeekerProfileRepository, UsersTypeRepositoty usersTypeRepositoty, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Optional<Users> getByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public Users addNew(Users users) {
        users.setActive(true);
        users.setRegistattionDate(new Date(System.currentTimeMillis()));
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Users savedUser = usersRepository.save(users); // Save user and get saved entity with ID

        int userTypeId = savedUser.getUserTypeId().getUserTypeId();
        if (userTypeId == 1) {
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        } else {
            jobSeekerProfileRepository.save( new JobSeekerProfile(savedUser));
        }
        return savedUser; // Ensure you return the entity with the assigned ID
    }


}
