package com.poly.recruiterproject.service;

import com.poly.recruiterproject.entity.JobPostActivity;
import com.poly.recruiterproject.repository.JobPostActivityRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPostActivityService {
    private JobPostActivityRepository jobPostActivityRepository;
    @Autowired
    public JobPostActivityService(JobPostActivityRepository jobPostActivityRepository) {
        this.jobPostActivityRepository = jobPostActivityRepository;
    }
    public JobPostActivity save(JobPostActivity jobPostActivity) {
        return jobPostActivityRepository.save(jobPostActivity);
    }
}
