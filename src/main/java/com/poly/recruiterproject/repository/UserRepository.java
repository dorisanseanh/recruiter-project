package com.poly.recruiterproject.repository;

import com.poly.recruiterproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
