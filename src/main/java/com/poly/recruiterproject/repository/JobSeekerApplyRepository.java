package com.poly.recruiterproject.repository;

import com.poly.recruiterproject.entity.JobPostActivity;
import com.poly.recruiterproject.entity.JobSeekerApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply, Integer> {
    List<JobSeekerApply> findByUserId(Integer userId);

    List<JobSeekerApply> findByJobSeekerId(JobPostActivity job);

}
