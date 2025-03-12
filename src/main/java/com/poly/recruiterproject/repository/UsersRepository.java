package com.poly.recruiterproject.repository;

import com.poly.recruiterproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    
}
