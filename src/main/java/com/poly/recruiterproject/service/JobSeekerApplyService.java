package com.poly.recruiterproject.service;

import com.poly.recruiterproject.entity.JobSeekerApply;
import com.poly.recruiterproject.repository.JobSeekerApplyRepository;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerApplyService {
    private JobSeekerApplyRepository jobSeekerApplyRepository;

    public JobSeekerApplyService(JobSeekerApplyRepository jobSeekerApplyRepository) {
        this.jobSeekerApplyRepository = jobSeekerApplyRepository;
    }
}
